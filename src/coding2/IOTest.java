package coding2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @Author: luanyanxu
 * @Date: 2019/7/2 18:55
 * @Version 1.0
 */
public class IOTest {

    public void addFile(String string,String path) {

        PrintStream stream=null;
        try {

            //写入的文件path
            stream=new PrintStream(path);
            //写入的字符串
            stream.print(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addFile1(String string,String path) {

        //文件的续写
        FileWriter fw = null;
        try {
            fw = new FileWriter(path,true);
            //写入换行
            //Windows平台下用\r\n，Linux/Unix平台下用\n
            fw.write("\r\n");
            //续写一个hello world!
            fw.write(string);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        IOTest ioTest = new IOTest();
        String path1 = "D:\\1.txt";
        String path2 = "D:\\2.txt";

        for (int i = 0; i <100 ; i++) {
            ioTest.addFile("luanyanxu"+i,path1);
        }

        for (int i = 0; i <100 ; i++) {
            ioTest.addFile1("luanyanxu"+i,path2);
        }



    }
}
