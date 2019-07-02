package coding.gc;

public class Product {
	public int product = 0;
	public final static int MAX = 999;
	public final static int MIN = 0;

	public synchronized void produce() {
		if (this.product >= MAX) {
			try {
				wait();
				System.out.println("�ֿ���������Ȼ�������");
			} catch (Exception e) {
				System.out.println("wait�����쳣");
			}
			return;
		}
		this.product++;
		System.out.println("++++����������" + this.product + "����Ʒ");
		notifyAll();
	}

	public synchronized void consume() {
		if (this.product <= MIN) {
			try {
				wait();
				System.out.println("�ֿ�ȱ������Ȼ�������");
			} catch (Exception e) {
				System.out.println("wait�����쳣");
			}
			return;
		}
		System.out.println("----�������ѵ�" + this.product + "����Ʒ");
		this.product--;
		notifyAll();
	}
	
	public static void main(String[] args) {
		Product p = new Product();
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		
	}
	
	
}
