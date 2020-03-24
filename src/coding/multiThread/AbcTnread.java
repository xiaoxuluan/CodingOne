package coding.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: alenlyx
 * @Date: 2019/10/15 14:10
 * @Version 1.0
 */
public class AbcTnread {

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"A");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"B");
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"C");
            }
        });

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 1; i < 11; i++) {
            executorService.submit(a);
            executorService.submit(b);
            executorService.submit(c);
        }


        executorService.shutdown();

    }


}
