package coding.multiThread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: luanyanxu
 * @Date: 2019/10/21 11:03
 * @Version 1.0
 */
public class ForkJoinDemo extends RecursiveTask<Long>{

    private long start;
    private long end;
    //long 64位 8Byte  -2^63------2^63-1 用在非常大型的系统上  long m = 50000L;
    //把long强转int会发生截断操作

    /**
     * 临界值
     */
    private static final long THRESHOLD = 10000;

    private ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long mid = (start + end) / 2;

            //拆分子任务1
            ForkJoinDemo forkJoinDemo1 = new ForkJoinDemo(start, mid);
            forkJoinDemo1.fork();

            //拆分子任务2
            ForkJoinDemo forkJoinDemo2 = new ForkJoinDemo(mid + 1, end);
            forkJoinDemo2.fork();

            //合并结果 进行返回
            return forkJoinDemo1.join() + forkJoinDemo2.join();
        }

    }

    public static void main(String[] args) {

        long m = 5000000000000000000L;
        int n = (int)m;
        System.out.println(n);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long sum = forkJoinPool.invoke(new ForkJoinDemo(1, 1000000000L));
        System.out.println(sum);
    }
}
