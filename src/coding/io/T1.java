package coding.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class T1 {
	
	public static void main(String[] args) {
		T1.writeAFileByBIO();
		T1.writeAFileByNIO();
		T1.writeAFileByAIO2();
	}
	
	public static void writeAFileByBIO(){
	    long length = 20 * 1024 * 1024;
	    byte b = 1;
	    File tmp = new File("F:\\tmp.txt");
	    FileOutputStream output = null;
	    try {
	        if (!tmp.exists()) {
	           tmp.createNewFile();
	        }
	        output = new FileOutputStream(tmp);
	        long start = System.currentTimeMillis();
	        while (length -- > 0) {
	            output.write(b);
	        }
	        System.out.println("BIO写入时间:" + (System.currentTimeMillis() - start) + "ms");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if(output != null) {
	            try {
	                output.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	
	public static void writeAFileByNIO(){
	    File tmp = new File("F:\\tmp1.txt");
	    FileChannel inChannel = null;
	    try {
	        if (!tmp.exists()) {
	            tmp.createNewFile();
	        }
	        RandomAccessFile aFile = new RandomAccessFile(tmp, "rw");
	        inChannel = aFile.getChannel();
	        //创建一个ByteBuffer，默认是写模式
	        ByteBuffer buf = ByteBuffer.allocate(1024 * 1024);
	        //将buffer的position设为0，limit设为capacity
	        buf.clear();
	        for (int j = 0; j < 1024 * 1024; j++) {
	            buf.put((byte) 1);
	        }
	        //转换为读模式将limit设为原来的position，position设为0.
	        buf.flip();
	        buf.mark();
	        long start = System.currentTimeMillis();
	        for (int i = 0; i < 20 ; i ++) {
	            buf.reset();
	            while (buf.hasRemaining()) {
	                inChannel.write(buf);
	            }
	        }
	        System.out.println("NIO写入时间:" + (System.currentTimeMillis() - start) + "ms");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if(inChannel != null) {
	            try {
	                inChannel.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	public static void writeAFileByAIO2(){
	    Path path = Paths.get("F:\\tmp2.txt");
	    AsynchronousFileChannel afc = null;
	    try {
	        afc   = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
	        List<Future<Integer>> results = new ArrayList<>();
	        ByteBuffer buf = ByteBuffer.allocate(1024 * 1024);
	        buf.clear();
	        for (int j = 0; j < 1024 * 1024; j++) {
	            buf.put((byte) 1);
	        }
	        buf.flip();
	        buf.mark();
	        long start = System.currentTimeMillis();
	        for (int i = 0; i < 20; i ++) {
	            buf.reset();
	            results.add(afc.write(buf, i * 1024 *1024));
	        }
	        for(Future<Integer> future : results) {
	            future.get();
	        }
	        System.out.println("AIO写入时间:" + (System.currentTimeMillis() - start) + "ms");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } catch (ExecutionException e) {
	        e.printStackTrace();
	    } finally {
	        if(afc != null) {
	            try {
	                afc.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

}
