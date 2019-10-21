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
    //long 64λ 8Byte  -2^63------2^63-1 ���ڷǳ����͵�ϵͳ��  long m = 50000L;
    //��longǿתint�ᷢ���ضϲ���

    /**
     * �ٽ�ֵ
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

            //���������1
            ForkJoinDemo forkJoinDemo1 = new ForkJoinDemo(start, mid);
            forkJoinDemo1.fork();

            //���������2
            ForkJoinDemo forkJoinDemo2 = new ForkJoinDemo(mid + 1, end);
            forkJoinDemo2.fork();

            //�ϲ���� ���з���
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
