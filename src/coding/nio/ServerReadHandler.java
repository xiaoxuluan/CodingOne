package coding.nio;
 
import java.nio.channels.SocketChannel;
 
public class ServerReadHandler extends ReadHandler {
	
	private NIOServer nioServer;
	
	public ServerReadHandler(SocketChannel socketChannel, NIOServer nioServer) {
		super(socketChannel);
		this.nioServer = nioServer;
	}
	
	protected synchronized void response(MsgPacket msgPacket) {
		final String content = new String(msgPacket.getData());
		System.out.println(Report.reportCurrentTime() + "receive content -> "
				+ content);
		
		// ģ���ʱ����
		try {
			Thread.sleep(100);
			// ģ��һ�»ظ��ͻ���
			nioServer.respone(socketChannel, Report.reportCurrentTime() + "Server reply -> " + content);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
