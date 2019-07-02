package coding.reentrantlock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPool {
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor  = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, 
				new ArrayBlockingQueue<Runnable>(5));
		for(int i=0;i<15;i++) {
			MyTask mytask = new MyTask(i);
			executor.execute(mytask);
			System.out.println("�̳߳��е��߳���Ŀ:"+executor.getPoolSize()+",�����еȴ�ִ��������Ŀ:"+executor.getQueue().size()
					+",�Ѿ�ִ������߳���Ŀ"+executor.getCompletedTaskCount());
		}
		executor.shutdown();
	}

}
class MyTask implements Runnable{

	private int taskNum;
	
	public MyTask(int num) {
		this.taskNum = num;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("����ִ�е�task"+taskNum);
		try {
			Thread.currentThread();
			Thread.sleep(4000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task"+taskNum+"ִ�����");
	}
	
}