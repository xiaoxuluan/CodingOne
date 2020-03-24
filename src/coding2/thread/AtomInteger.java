package coding2.thread;

/**
 * @Author: alenlyx
 * @Date: 2019/9/4 17:32
 * @Version 1.0
 */
public class AtomInteger {

    private static final int THREADS_COUNT = 20;

    public static int count = 0;

    private static void increase(){
        count++;
    }

    public static void main(String[] args) {
          Thread [] threads = new Thread[THREADS_COUNT];
          for (int i =0;i<THREADS_COUNT;i++){
              threads[i] = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      for (int i=0;i<1000;i++){
                          System.out.println(Thread.currentThread().getName()+i);
                          increase();
                      }
                  }
              });
              threads[i].start();
          }

          while (Thread.activeCount()>1){
              Thread.yield();
          }
        System.out.println(count);
    }
}
