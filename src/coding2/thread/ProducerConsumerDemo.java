package coding2.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: luanyanxu
 * @Date: 2020/4/3 14:29
 * @Version 1.0
 */


public class ProducerConsumerDemo {
    //�̲߳�����Դ��
    //���ھۣ������
    //�Ϸ����߳��µ���ٻ���

    //��ͳ�� ������  ������
    //���̵߳��ж� ���ܷ���if����  ������ٻ���

    //


    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()  ->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5 ; i++) {
                try {
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"BBB").start();

        new Thread(()  ->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"CCC").start();

        new Thread(() -> {
            for (int i = 0; i < 5 ; i++) {
                try {
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"DDD").start();
    }
}


class ShareData{
    //һ�нԶ���

    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    public void increment() throws Exception{

        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }

            //2.�ɻ�
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception{
        //1.�ж�����

        lock.lock();
        try {
            while(number == 0){
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}