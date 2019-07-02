package coding.proxy;

public class ProxyPatternDemo {
	
	public static void main(String[] args) {
		Image image = new ProxyImage("lyx.jpg");
		
		//м╪оЯ╫╚╢с╢еел╪сть
		image.display();
		System.out.println();
		image.display();
	}

}
