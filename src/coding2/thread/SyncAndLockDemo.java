package coding2.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: luanyanxu
 * @Date: 2020/4/3 20:04
 * @Version 1.0
 */
class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    //1.�ж�

    //2.�ɻ�
    //3.֪ͨ
}

class MyResource{
    private volatile boolean FLAG = true;//Ĭ�Ͽ�������������+����
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while(FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName()+"\t�������"+data+"�ɹ�");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t�������"+data+"ʧ��");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t����ֹͣ");
    }

    public void myConsumer() throws Exception{
        String result = null;
        while(FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null==result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t ����2�룬�����˳�");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t���Ѷ���"+result+"�ɹ�");
        }
    }

    public void stop() throws Exception{
        this.FLAG = false;
    }
}

/*
 * volatile/CAS/atomicInteger/BlockQueue/�߳̽���/ԭ������
 * */

public class SyncAndLockDemo {
    public static void main(String[] args) throws Exception{
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t �����߳�����");
            System.out.println();
            System.out.println();
            try{
                myResource.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t �����߳�����");
            try{
                myResource.myConsumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"Consumer").start();

        try{TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e){e.printStackTrace();}

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("5���ӵ���mainֹͣ");
        myResource.stop();
    }
}
