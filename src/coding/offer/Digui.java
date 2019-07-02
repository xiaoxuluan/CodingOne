package coding.offer;

public class Digui {
	
	public static int getNum(int num) {
		if(num==0) {
			return num;
		}else {
			System.out.println(num-1);
			return num + getNum(num - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getNum(10));
	}

}
