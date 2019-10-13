package coding.multiThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseFuture {
	
	/*ʵ��Callable�ӿڣ������з���ֵ*/
	private static class UseCallable implements Callable<Integer> {
 
		private int sum;
		@Override
		public Integer call() throws Exception {
			System.out.println("Callable���߳̿�ʼ����");
			Thread.sleep(2000);
			for(int i=0;i<5000;i++) {
				sum = sum+i;
			}
			System.out.println("Callable���̼߳�����ɣ����="+sum);
			return sum;
		}
 
	}
	
	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		
		UseCallable useCallable = new UseCallable();
		FutureTask<Integer> futureTask = new FutureTask<>(useCallable);
		new Thread(futureTask).start();
		Random r = new Random();

		if(r.nextBoolean()) {//��������ǻ�ý��������ֹ����
			System.out.println("Get UseCallable result = "+futureTask.get());
		}else {
			System.out.println("�жϼ���");
			System.out.println(futureTask.cancel(true));
		}
		
	}
 
}
