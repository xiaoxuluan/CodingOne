package coding.niotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Date;

public class Nio1 {
	
	

	private static void writeFile() throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream out = new FileOutputStream("F://lyx.txt");
		FileChannel fc = out.getChannel();
		
		ByteBuffer source = Charset.forName("utf8").encode("hello lyx1"+new Date());
	
		for (int i = 0; i < 50; i++) {
			fc.write(source);
		}
	}

	
	public  static void readFile() throws Exception {
		FileInputStream input = new FileInputStream("F://lyx.txt");
		
		FileChannel fc = input.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(20);
		
		int length = -1;
		
		while((length=fc.read(buffer))!=-1) {
			byte [] bytes = buffer.array();
				System.out.write(bytes,0,length);
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Nio1.writeFile();
		Nio1.readFile();
	}


}
