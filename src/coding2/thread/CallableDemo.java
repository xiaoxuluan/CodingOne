package coding2.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: luanyanxu
 * @Date: 2020/4/4 10:11
 * @Version 1.0
 */

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("-------comi in callable demo");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        Thread t1 = new Thread(futureTask,"AA");
        t1.start();
        int r1 = 100;
        int r2 = futureTask.get();
        System.out.println("sum=" +(r1+r2));
    }

}
