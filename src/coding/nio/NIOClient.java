package coding.nio;
 
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author luanaynxu
 *
 *2018��12��27��
 */
public class NIOClient {
	// ���еȴ��ʱ��
	private static final int MAX_IDLE_COUNT = 60;
	// ������󻺴�����С
	private static final int BUFFER_SIZE = 1024 * 8;
	// �Ƿ�رտͻ��˵ı�־
	private boolean isClosed = false;
	// ͨ��������
	private Selector selector;
	// �����˽�����socketͨ��
	private SocketChannel socketChannel;
	// ����Ķ�����
	private ByteBuffer readBuffer;
	// ��������
	private ReadHandler readHandler;
	// ��д����
	private LinkedList<ByteBuffer> bufferQueue;
	
	// ��ǰ���м���
	private int idleCount;
	
	private String serverIP;
	private int port;
	private String name;
	
	public String getName() {
		return this.name;
	}
	
	public NIOClient() {}
	
	public NIOClient(String serverIP, int port) {
		this.serverIP = serverIP;
		this.port = port;
	}
	
	public NIOClient(String name, String serverIP, int port) {
		this.name = name;
		this.serverIP = serverIP;
		this.port = port;
	}
	
	// ��ɳ�ʼ������
	private void init() {
		
		idleCount = 0;
		
		// ��ʼ��������
		readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
		// ��ʼ����д����
		bufferQueue = new LinkedList<ByteBuffer>();
		
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			// ��Ҫ����Ϊ������ģʽ���ܽ���һϵ�в���
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress(serverIP, port));
			selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ����
	public void startup() {
		// ��ɳ�ʼ��
		init();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					while (!isClosed) {
						int nKey = selector.select(1000);	// ���MAX_IDLE_COUNT �ȼ��� MAX_IDLE_COUNT(s)����ʱ����
						if (nKey > 0) {
							idleCount = 0;
							Set<SelectionKey> keySet = selector.selectedKeys();
							Iterator<SelectionKey> iterator = keySet.iterator();
							while (iterator.hasNext()) {
								SelectionKey key = iterator.next();
								iterator.remove();
								if (key.isConnectable()) {
									// �����¼�
									finishedConnection(key);
								} else if (key.isReadable()) {
									// ���¼�
									readFromChanel(key);
								} else if (key.isWritable()) {
									// д�¼�
									writeToChannel(key);
								}
							}
						} else {
							idleCount++;
							if(idleCount >= MAX_IDLE_COUNT) {
								// ���г�ʱ,�Ͽ���ͻ��˵�����
								close();
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
	private void finishedConnection(SelectionKey key) {
		SocketChannel socketChannel = (SocketChannel) key
				.channel();
		if (socketChannel.isConnectionPending()) {
			try {
				socketChannel.finishConnect();
				socketChannel.configureBlocking(false);
				// ע���Ȩ��
				socketChannel.register(selector,
						SelectionKey.OP_READ);
				this.socketChannel = socketChannel;
				readHandler = new ClientReadHandler(this, this.socketChannel);
				System.out.println(Report.reportCurrentTime() + this.name + " Connect to Server");
				
				final String msg = "���ط��������!" + "����" + this.getName();
				final String msg1 = "����" + this.getName() + " ���ط��������!";
				send(msg);
				send(msg1);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void readFromChanel(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        // ��ն�����
        readBuffer.clear();
        try {
			int count = channel.read(readBuffer);
//			System.out.println("count = " + count);
			if(count > 0) {
				byte[] data = new byte[count];
				System.arraycopy(readBuffer.array(), 0, data, 0, count);
				readHandler.read(data);
				readHandler.handle();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				socketChannel.close();
				key.cancel();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public boolean isClosed() {
		return isClosed;
	}
	
	public void close() {
		try {
			// ʹ�߳��˳�
			isClosed = true;
			selector.close();
			socketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		MsgPacket msgPacket = new MsgPacket(msg);
		// ��ӵ�д����
		bufferQueue.add(ByteBuffer.wrap(msgPacket.getBytes()));
		socketChannel.keyFor(this.selector).interestOps(SelectionKey.OP_WRITE);
		// ����
		selector.wakeup();
	}
	
	// ��ͨ��д
	private void writeToChannel(SelectionKey key) {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		while(!bufferQueue.isEmpty()) {
			ByteBuffer buffer = bufferQueue.get(0);
			try {
				socketChannel.write(buffer);
				if(buffer.remaining() > 0) {
					break;
				}
				bufferQueue.remove(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(bufferQueue.isEmpty()) {
			// ȫ������д���� ȡ��д�ȴ��¼�
			key.interestOps(SelectionKey.OP_READ);
		}
	}
	
	public static void main(String[] args) {
		NIOClient client = new NIOClient("127.0.0.1", 9000);
		client.startup();
		System.out.println(Report.reportCurrentTime() + " client startup");
	}
	
}

