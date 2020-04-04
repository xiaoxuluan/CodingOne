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
    //线程操作资源类
    //高内聚，低耦合
    //严防多线程下的虚假唤醒

    //传统版 生产者  消费者
    //多线程的判断 不能放在if里面  存在虚假唤醒

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
    //一切皆对象

    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    public void increment() throws Exception{

        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }

            //2.干活
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
        //1.判断消费

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