package coding2.l2;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/21 20:58
 * @Version 1.0
 */
public class Thread2 {

    public static void main(String[] args) {

        System.out.println(new Date().toLocaleString());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(new Date()+" " +Thread.currentThread().getName()+"  "+temp);
                }
            },3, TimeUnit.SECONDS);
        }
    }
}
