package coding2.review;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/25 7:39
 * @Version 1.0
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        try {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(5));

            ThreadDemo temp = new ThreadDemo("hello");

            executor.execute(temp);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadDemo extends Thread{
    private String threadname ;

    ThreadDemo(String name){
        threadname = name;
        System.out.println("Create "+threadname);
    }

    @Override
    public void run(){
        System.out.println("Running "+threadname);

        try {
            for (int i = 4; i >0 ; i--) {
                System.out.println("Thread: " + threadname + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadname + " interrupted.");
        }

        System.out.println("Thread " +  threadname + " exiting.");

    }
}
