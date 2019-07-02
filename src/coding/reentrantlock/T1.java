package coding.reentrantlock;

public class T1 implements Runnable{
	 //外层线程在获得锁以后，其他线程任然可以获得其他锁
	public synchronized void get(){
		System.out.println(Thread.currentThread().getId());
		set();
	}
 
	public synchronized void set(){
		System.out.println(Thread.currentThread().getId());
	}
 
	@Override
	public void run() {
		get();
	}
	public static void main(String[] args) {
		T1 ss=new T1();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
	}
}

