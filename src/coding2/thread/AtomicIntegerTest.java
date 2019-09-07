package coding2.thread;

/**
 * @author luanyanxu
 */
public class AtomicIntegerTest {
 
    private static final int THREADS_CONUT = 20;
    public static int count = 0;
 
    public static void increase() {
        count++;
    }
 
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_CONUT];
        for (int i = 0; i < THREADS_CONUT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
 

        System.out.println(count);
    }
}
