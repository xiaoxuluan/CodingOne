package coding2.thread;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/26 14:55
 * @Version 1.0
 */
public class Counter implements Runnable {

    private int count;

    public Counter(){
        count = 0;
    }

    public void countAdd(){
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() +" "+(count++));
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void printCount(){
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(Thread.currentThread().getName()+" "+count);
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if(threadName.equals("A")){
            countAdd();
        }else if(threadName.equals("B")){
            printCount();
        }
    }
}
