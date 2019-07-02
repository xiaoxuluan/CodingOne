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

            //д����ļ�path
            stream=new PrintStream(path);
            //д����ַ���
            stream.print(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addFile1(String string,String path) {

        //�ļ�����д
        FileWriter fw = null;
        try {
            fw = new FileWriter(path,true);
            //д�뻻��
            //Windowsƽ̨����\r\n��Linux/Unixƽ̨����\n
            fw.write("\r\n");
            //��дһ��hello world!
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
