package coding.concurrent;

import java.util.concurrent.CountDownLatch;

public class Counter {
    private static volatile int value;
    private static CountDownLatch countDownLatch = new CountDownLatch(10000);
    public static void main(String[] args) throws Exception{
        for (int i=0;i<10000;i++){
            new Thread(){
                @Override
                public void  run() {
                    increment();
                    countDownLatch.countDown();
                }
            } .start();

        }
        countDownLatch.await();
        System.out.println(getValue());
    }

    public static synchronized int increment(){
        return value ++;
    }

    public static int getValue(){
        return value;
    }

}
