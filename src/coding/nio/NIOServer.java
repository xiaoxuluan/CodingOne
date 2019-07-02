package coding.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author luanaynxu
 *
 *2018��12��27��
 */
public class NIOServer {

	// �����С ������ô�һЩ,����Ҳ��Ҫ���̫��(��������2)
	private static final int BUFFER_SIZE = 1024 * 8;
	// ͨ��������
	private Selector selector;
	// �������̳߳�
	private ThreadPoolExecutor readPoolExecutor;
	// ���������
	private ByteBuffer byteBuffer;
	// �����ͻ������ӵ�SocketChannel�����д����
	private Map<SocketChannel, LinkedList<ByteBuffer>> writeBufferMap;
	// �����ͻ������ӵ�SocketChannel��ReadHandler(һ���ͻ��˶�Ӧһ��ReadHandler)
	private Map<SocketChannel, ReadHandler> SRMap;
	// ����������
	private int connnectCount;

	private String ip;
	private int port;

	public NIOServer() {
	}

	public NIOServer(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	// ��ʼ��
	private void init() {
		final int processors = Runtime.getRuntime().availableProcessors();
		readPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(processors * 2);
		// ��ʼ�����������
		byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
		// ��ʼ��д����
		writeBufferMap = new ConcurrentHashMap<SocketChannel, LinkedList<ByteBuffer>>();
		// ��ʼ��SRMap
		SRMap = new ConcurrentHashMap<SocketChannel, ReadHandler>();
		// ��ʼ��������
		connnectCount = 0;

		ServerSocketChannel serverSocketChannel = null;
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(ip, port));
			serverSocketChannel.configureBlocking(false);
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����
	public void startup() {
		// ��ɳ�ʼ��
		init();
		// �������������
		System.out.println(Report.reportCurrentTime() + " server startup...");
		System.out.println(Report.reportCurrentTime() + " server listen on " + ip + " port " + port);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// һֱ��
				while (!Thread.interrupted()) {
					try {
						// ���������� ���д��selector.select(1000)���������1000ms
						int nKey = selector.select();
						if (nKey > 0) {
							Set<SelectionKey> keySet = selector.selectedKeys();
							Iterator<SelectionKey> iterator = keySet.iterator();
							while (iterator.hasNext()) {
								final SelectionKey key = iterator.next();
								// �Ƴ�,�����ظ�����
								iterator.remove();
								// ����key�����ͽ����ж� OP_ACCEPT|OP_READ|OP_WRITE
								if (key.isValid() && key.isAcceptable()) {
									// ���������������
									acceptConnection(key);
								} else if (key.isValid() && key.isReadable()) {
									// ���������
									readFromChannel(key);
								} else if (key.isValid() && key.isWritable()) {
									// ����д����
									writeToChannel(key);
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	// ���տͻ�����������
	private void acceptConnection(SelectionKey key) {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
		// ���ܿͻ�������
		Socket socket = null;

		try {
			socket = serverSocketChannel.accept().socket();
			SocketChannel socketChannel = socket.getChannel();
			// ����ͨ��������
			socketChannel.configureBlocking(false);

			// ע���Ȩ��
			socketChannel.register(selector, SelectionKey.OP_READ);

			// ����д����
			socketChannel.write(ByteBuffer.wrap(new MsgPacket(Report.reportCurrentTime() + "��ӭ�������ط�����").getBytes()));
			System.out.println(Report.reportCurrentTime() + "accept one Client");
			connnectCount++;
			// ����SocketChannel�봦���ͨ����ReadHandler
			SRMap.put(socketChannel, new ServerReadHandler(socketChannel, this));
			// ����SocketChannel�����д����
			writeBufferMap.put(socketChannel, new LinkedList<ByteBuffer>());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ��ͨ����
	private void readFromChannel(SelectionKey key) {
		final SocketChannel socketChannel = (SocketChannel) key.channel();
		synchronized (byteBuffer) {
			byteBuffer.clear();
			try {
				final int count = socketChannel.read(byteBuffer);
//				System.out.println("count = " + count);
				if (count > 0) { // ����
					final byte[] data = new byte[count];
					System.arraycopy(byteBuffer.array(), 0, data, 0, count);
					final ReadHandler readHandler = SRMap.get(socketChannel);
					readHandler.read(data);
					// �̳߳ش���
					readPoolExecutor.execute(new Runnable() {

						@Override
						public void run() {
//							readHandler.handle(array, count);
							readHandler.handle();
						}
					});
				} else if (count < 0) { // �ͻ��������Ͽ�����
					connnectCount--;
					// �ͷ���Դ
					releaseResource(socketChannel);
					socketChannel.close();
					key.cancel();
					System.out.println("�ͻ��������Ͽ�����," + " ʣ��������: " + connnectCount);
				}
			} catch (IOException e) {
				e.printStackTrace();
				try {
					if (socketChannel != null && socketChannel.isOpen()) {
						// ����ͻ����쳣�Ͽ�
						socketChannel.close();
					}
					// ȡ������Ȥ���¼�
					key.cancel();
					// �Ƴ����socketChannel����Դ
					releaseResource(socketChannel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	// ģ����Ӧ
	public synchronized void respone(SocketChannel socketChannel, String msg) {
		MsgPacket msgPacket = new MsgPacket(msg);
		LinkedList<ByteBuffer> bufferQueue = writeBufferMap.get(socketChannel);
		// ��ӵ�д����
		bufferQueue.add(ByteBuffer.wrap(msgPacket.getBytes()));
		socketChannel.keyFor(this.selector).interestOps(SelectionKey.OP_WRITE);
		// ����
		selector.wakeup();
	}

	// ��ͨ��д
	private synchronized void writeToChannel(SelectionKey key) {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		LinkedList<ByteBuffer> bufferQueue = writeBufferMap.get(socketChannel);
		while (!bufferQueue.isEmpty()) {
			ByteBuffer buffer = bufferQueue.get(0);
			try {
				socketChannel.write(buffer);
				if (buffer.remaining() > 0) {
					// �û������е��ֽڻ�û��д��,break,����һ��write key����д
					break;
				}
				// д��һ��buffer
				bufferQueue.remove(0);
			} catch (IOException e) {
				e.printStackTrace();
				// ����ͻ����쳣�Ͽ�
				try {
					if (socketChannel != null && socketChannel.isOpen()) {
						socketChannel.close();
					}
				} catch (IOException e1) { // �ر�ʱ��������ClosedChannelException
					e1.printStackTrace();
				} finally {
					// ȡ������Ȥ���¼�
					key.cancel();
					// �ͷ���Դ
					releaseResource(socketChannel);
				}
			}
		}
		if (bufferQueue.isEmpty()) {
			// ȫ������д����
			// ȡ��д�ȴ��¼�(��ȡ�������cpu�ܿ�ﵽ100%,��ΪOP_WRITEû���Ƴ�,seletor.select()��������,һֱִ��while��ѭ��)
			key.interestOps(SelectionKey.OP_READ);
		}
	}

	// �ͷ���Դ
	private synchronized void releaseResource(SocketChannel socketChannel) {
		SRMap.remove(socketChannel);
//		System.out.println("SRMap size = " + SRMap.size());
		writeBufferMap.remove(socketChannel);
//		System.out.println("writeBufferMap size = " + writeBufferMap.size());
	}

	public static void main(String[] args) {
		NIOServer server = new NIOServer("127.0.0.1", 9000);
		server.startup();
	}

}
