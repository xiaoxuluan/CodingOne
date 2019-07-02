package coding.concurrent;

class SaleRunable implements Runnable {

	private volatile int ticket = 20;

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {

			synchronized (this) {
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + "ย๔ณ๖มหตฺ" + (20 - ticket + 1) + "ฦฑ");
					ticket--;
				} else {
					break;
				}
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}

public class MultiThreadAddLock {

	public static void main(String[] args) {
		SaleRunable r = new SaleRunable();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		t1.start();
		t2.start();
		t3.start();
	}

}
