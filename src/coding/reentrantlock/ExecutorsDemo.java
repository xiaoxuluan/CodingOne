package coding.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*** Created by hujian06 on 2017/10/31.** the demo of Executors */
public class ExecutorsDemo {
	public static void main(String[] args) {
		int cpuCoreCount = Runtime.getRuntime().availableProcessors();
		AThreadFactory threadFactory = new AThreadFactory();
		ARunnable runnanle = new ARunnable();
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cpuCoreCount, threadFactory);
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool(threadFactory);
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(cpuCoreCount, threadFactory);
		ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor(threadFactory);
		fixedThreadPool.submit(runnanle);
		cachedThreadPool.submit(runnanle);
		newScheduledThreadPool.scheduleAtFixedRate(runnanle, 0, 1, TimeUnit.SECONDS);
		singleThreadExecutor.scheduleWithFixedDelay(runnanle, 0, 100, TimeUnit.MILLISECONDS);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fixedThreadPool.shutdownNow();
		cachedThreadPool.shutdownNow();
		newScheduledThreadPool.shutdownNow();
		singleThreadExecutor.shutdownNow();
	}
}

class ARunnable implements Runnable {
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Current Thread Name:" + Thread.currentThread().getName());
	}
}

/*** the thread factory */
class AThreadFactory implements ThreadFactory {
	private final AtomicInteger threadNumber = new AtomicInteger(1);

	@Override
	public Thread newThread(Runnable r) {
		return new Thread("aThread-" + threadNumber.incrementAndGet());
	}
}
