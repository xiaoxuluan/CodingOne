package coding2.review;

import coding.reentrantlock.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @Author: alenlyx
 * @Date: 2019/10/16 16:07
 * @Version 1.0
 */
public class MyTaskDemo implements Callable<Object> {

    private String args1;
    private String args2;
    private MyTaskDemo(String args1, String args2) {
        this.args1 = args1;
        this.args2 = args2;
    }

    @Override
    public Object call() throws Exception {

        StringBuilder result = new StringBuilder("hello");
        for (int i = 0; i < 10; i++) {
             result.append(i);
        }
        return result;
    }

    //多个计算任务 使用线程池实现
    public static void main(String[] args) {
        List<FutureTask<Object>> futureTasks = new ArrayList<>();

        for (Integer i = 0; i < 10; i++) {
            MyTaskDemo myTaskDemo = new MyTaskDemo(i.toString(), i.toString());
            futureTasks.add(new FutureTask<>(myTaskDemo));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (FutureTask<Object> futureTask : futureTasks) {
            executorService.submit(futureTask);
        }

        executorService.shutdown();

        for (Integer i = 0; i < 10; i++) {
            try {
                StringBuilder flag = (StringBuilder) futureTasks.get(i).get();
                System.out.println(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //单个计算任务 使用Threadsh实现
    /*public static void main(String[] args) {
        MyTaskDemo myTaskDemo = new MyTaskDemo("11","22");
        FutureTask<Object> futureTask = new FutureTask<>(myTaskDemo);

        Thread thread = new Thread(futureTask);

        thread.start();
        try {
            boolean result = (boolean) futureTask.get();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
