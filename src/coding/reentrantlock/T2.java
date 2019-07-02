package coding.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class T2 implements Runnable {
	ReentrantLock lock = new ReentrantLock();
 
	public void get() {
		lock.lock();//���������������Ժ� �ڵ�11����Ȼ���Ի���� ����ִ��
		System.out.println(Thread.currentThread().getId());
		set();//get()�����ڻ�����Ժ󣬼���ִ�����µĴ��� set()������Ȼ���Ի����
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

