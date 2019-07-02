package coding.nio;
 
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
 
public abstract class ReadHandler {
	
	// ��Ž��յ��ֽ�����
	protected LinkedList<byte[]> dataList = new LinkedList<byte[]>();
	// ��Ŷ�ȡ���ֽ���
	protected int readCount = 0;
	// ���δ������ɵİ�
	protected LinkedList<MsgPacket> packetQueue = new LinkedList<MsgPacket>();
	// ��Ӧ��SocketChannel
	protected SocketChannel socketChannel;
	
	public ReadHandler() {}
	
	public ReadHandler(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}
	
	public synchronized void read(byte[] data) {
		dataList.add(data);
		readCount = readCount + data.length;
	}
	
	public synchronized void handle() {
		if(readCount == 0) {
			return ;
		}
		boolean flag = true;
		byte[] bytes = toBytes();
//		System.out.println("handle data = " + new String(bytes));
		while (flag) {
			switch (bytes[0]) {
			case MsgPacket.MSG_FLAG:
				if (bytes.length < MsgPacket.HEADER_SIZE) {
					// ��ʱ������header��û�н�����
					MsgPacket msgPacket = new MsgPacket(bytes);
					packetQueue.add(msgPacket);
					flag = false;
				} else {
					byte[] header = new byte[MsgPacket.HEADER_SIZE];
					header[0] = MsgPacket.MSG_FLAG;
					header[1] = bytes[1];
					header[2] = bytes[2];
					MsgPacket msgPacket = new MsgPacket(header);
					bytes = adjust(bytes, bytes.length - header.length);
					if (bytes.length - header.length == 0) {
						// �պ��ǽ�����һ������header����
						packetQueue.add(msgPacket);
						flag = false;
					} else {
						int more = bytes.length;
						int length = bytes.length > msgPacket.getNeedDataLength() ? msgPacket.getNeedDataLength() : bytes.length;
						byte[] newdata = new byte[length];
						// �����header��ʣ������ݴ���msgPacket�м�¼�����ݳ���,��ô֤������ʣ��İ�
						System.arraycopy(bytes, 0, newdata, 0, length);
						msgPacket.read(newdata);
						if (msgPacket.isCompleted()) {
							// �������ش�����,������Ӧ����
							response(msgPacket);
							// ������һ����,����ʣ�೤��
							more = more - length;
							if (more > 0) {
								// ��������������,���µ���bytes����
								bytes = adjust(bytes, more);
							} else { // �պ��Ǵ���һ�����ĳ���
								flag = false;
							}
						} else {
							// �������ݲ��ֽ��ղ�����
							// �ŵ������ٽ��д���
							packetQueue.add(msgPacket);
							flag = false;
						}
					}
				}
				break;
			default:
				// ���͵����ݰ�����һ��δ��ɵĲ���,���Ŵ���ǰ��δ������İ�
				if(!packetQueue.isEmpty()) {
					MsgPacket msgPacket = packetQueue.get(0);
					// ���ܵ����: 1.��֪��������(headerû�н�������) 2.֪��������
					if(!msgPacket.isHeaderCompleted()) {	// ��headerû�н�������
						// ����header���ֽ��ղ�����
						byte[] unCompletedHeader = msgPacket.getHeader();
						// ����header����
						int curLength = unCompletedHeader.length;
						byte[] header = new byte[MsgPacket.HEADER_SIZE];
						// ��Ҫ��ȫ��header����
						int needLength = header.length - unCompletedHeader.length;
						// ����ԭ����
						System.arraycopy(unCompletedHeader, 0, header, 0, curLength);
						// ���ϲ����
						System.arraycopy(bytes, 0, header, curLength, needLength);
						// ��������header,�������ݳ��ȺͰ�����
						msgPacket.resetHeader(header);
						msgPacket.calLength();
						// ���µ���bytes����(ȥ��header)
						int more = bytes.length - needLength;
						bytes = adjust(bytes, more);
					}
					int more = bytes.length;
					int length = bytes.length > msgPacket.getNeedDataLength() ? msgPacket.getNeedDataLength() : bytes.length;
					byte[] newdata = new byte[length];
					// �����header��ʣ������ݴ���msgPacket�м�¼�����ݳ���,��ô֤������ʣ��İ�
					System.arraycopy(bytes, 0, newdata, 0, length);
					msgPacket.read(newdata);
					if (msgPacket.isCompleted()) {
						
						// �������ش�����,���������Ӧ����
						response(msgPacket);
						
						// �˳�����
						packetQueue.remove(0);
						
						// ������һ����,����ʣ�೤��
						more = more - length;
						if (more > 0) {
							// ��������������,���µ���bytes����
							bytes = adjust(bytes, more);
						} else { // �պ��Ǵ���һ�����ĳ���
							flag = false;
						}
					} else {
						// �������ݲ��ֽ��ղ�����
						// �������Ѿ��ڶ��������� ����Ҫ��add
//						packetQueue.add(msgPacket);
						flag = false;
					}
				}
				break;
			}
		}
	}
	
	// ���յ����ֽ�ת��Ϊһ������,���д���
	private byte[] toBytes() {
		byte[] bytes = new byte[readCount];
		int destPos = 0;
		while(!dataList.isEmpty()) {
			byte[] bytes0 = dataList.remove(0);
			System.arraycopy(bytes0, 0, bytes, destPos, bytes0.length);
			destPos = destPos + bytes0.length;
		}
		readCount = 0;
		return bytes;
	}
	
	// ����bytes��ʣ����ֽڵ��µ�����,������
	protected byte[] adjust(byte[] bytes, int more) {
		byte[] tmp = new byte[more];
		
		int completed = bytes.length - more;
		// �Ӻ���ǰ����
		for(int i = bytes.length - 1,j = tmp.length - 1; i >= completed; i--,j--) {
			tmp[j] = bytes[i];
		}
		return tmp;
	}
	
	// �յ����ݺ����Ӧ����
	protected abstract void response(MsgPacket msgPacket);
	
}
