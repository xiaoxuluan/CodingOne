package coding2.l2;

import coding.reentrantlock.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: alenlyx
 * @Date: 2020/3/21 16:54
 * @Version 1.0
 */
public class Thread1 {

    public static void main(String[] args) {

        ExecutorService newfixPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int temp = i;
            newfixPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName:"+Thread.currentThread().getName()+",i:"+temp);
                }
            });
        }

        newfixPool.shutdown();
    }
}
