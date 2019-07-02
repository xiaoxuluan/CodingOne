package coding.nio;
 
/**
 * �ð����ڷ�װ���͵���Ϣ�Ͷ�ȡ���͵���Ϣ
 * @author CrazyPig
 *
 */
public class MsgPacket {
	
	public static final byte MSG_FLAG = 0x01;
	public static final int HEADER_SIZE = 3;
	
	private byte[] header = new byte[HEADER_SIZE];	// ��һ���ֽ�Ϊ������,���������ֽڱ�ʾ���ݳ���
	private byte[] data;	// ����
	private int length;	// ������
	
	private int curDataLength = 0;	// ��ǰdata[]����
	
	public byte[] getData() {
		return this.data;
	}
	public byte[] getHeader() {
		return this.header;
	}
	public int getPacketLength() {
		return this.length;
	}
	public int getDataLength() {
		return this.length - header.length;
	}
	public int getCurDataLength() {
		return this.curDataLength;
	}
	
	// ��ȡ����Ҫ���������ֽڳ���
	public int getNeedDataLength() {
		return this.getDataLength() - this.getCurDataLength();
	}
	
	// ���ݷ��͵���Ϣ����һ����
	public MsgPacket(String msg) {
		this.data = msg.getBytes();
		this.length = data.length + header.length;
		int dlen = data.length;
		genHeader(dlen);
	}
	
	// �����յ���header����һ����
	public MsgPacket(byte[] header) {
		this.header = header;
		if(header.length < HEADER_SIZE) {
			return ;
		}
		// �����ݳ���
		calLength();
	}
	
	// �����ݳ���
	public void calLength() {
		byte high = (byte) ((header[1] << 8) & 0xff00);
		byte low = (byte) (header[2] & 0x00ff);
		int dataLength = (high | low);
		this.data = new byte[dataLength];
		this.length = dataLength + header.length;
	}
	
	public void read(byte[] newdata) {
		// ����newdata[]�������ݵ�data[]����
		System.arraycopy(newdata, 0, this.data, this.curDataLength, newdata.length);
		this.curDataLength += newdata.length;
	}
 
	// �жϰ��Ƿ�����
	public boolean isCompleted() {
		int curLength = this.curDataLength + this.header.length;
		return curLength == this.length;
	}
	
	// �ж�header�Ƿ�����
	public boolean isHeaderCompleted() {
		return header.length == HEADER_SIZE;
	}
	
	public void genHeader(int dataLength) {
		header[0] = MSG_FLAG;
		// header[1] ���ֽ�
		header[1] = (byte) ((dataLength & 0xff00) >> 8);
		header[2] = (byte) (dataLength & 0x00ff);
	}
 
	// ����������������
	public byte[] getBytes() {
		byte[] allBytes = new byte[this.length];
		System.arraycopy(header, 0, allBytes, 0, this.header.length);
		System.arraycopy(data, 0, allBytes, this.header.length, this.data.length);
		return allBytes;
	}
	
	// ����header
	public void resetHeader(byte[] header) {
		this.header = header;
	}
	
}

