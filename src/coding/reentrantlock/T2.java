package coding.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class T2 implements Runnable {
	ReentrantLock lock = new ReentrantLock();
 
	public void get() {
		lock.lock();//就是在这里获得锁以后 在第11行仍然可以获得锁 继续执行
		System.out.println(Thread.currentThread().getId());
		set();//get()方法在获得锁以后，继续执行以下的代码 set()方法仍然可以获得所
		lock.unlock();
	}
 
	public void set() {
		lock.lock();
		System.out.println(Thread.currentThread().getId());
		lock.unlock();
	}
 
	@Override
	public void run() {
		get();
	}
 
	public static void main(String[] args) {
		T2 ss = new T2();
		new Thread(ss).start();
		new Thread(ss).start();
		new Thread(ss).start();
	}
}

