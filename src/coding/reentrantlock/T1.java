package coding.reentrantlock;

public class T1 implements Runnable{
	 //����߳��ڻ�����Ժ������߳���Ȼ���Ի��������
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

