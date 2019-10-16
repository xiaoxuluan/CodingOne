package coding.multiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //�̶���С�̳߳�ʹ��
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //����һ��Callable��3��󷵻�String����
        Callable myCallable = new Callable() {

            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                System.out.println("calld����ִ����");
                return "����call��������ֵ";
            }

        };
        System.out.println("�ύ����֮ǰ " + getStringDate());
        Future future = executor.submit(myCallable);
        System.out.println("�ύ����֮�󣬻�ȡ���֮ǰ " + getStringDate());
        System.out.println("��ȡ����ֵ: " + future.get());
        System.out.println("��ȡ�����֮�� " + getStringDate());
        executor.shutdown();
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
}