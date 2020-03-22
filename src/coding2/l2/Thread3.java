package coding2.l2;

import java.util.concurrent.*;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/21 21:07
 * @Version 1.0
 */
public class Thread3 {

    public static void main(String[] args) {
        ExecutorService  pool = new ThreadPoolExecutor(
                5,500,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 10; i++) {

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });


        }

        pool.shutdown();
    }
}
