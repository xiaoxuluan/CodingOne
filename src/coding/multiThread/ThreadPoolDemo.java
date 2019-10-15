package coding.multiThread;

import coding.reentrantlock.ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: luanyanxu
 * @Date: 2019/10/15 14:37
 * @Version 1.0
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                200,
                2L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(()->
                    System.out.println(Thread.currentThread().getName()));
        }
        threadPoolExecutor.shutdown();
    }
}
