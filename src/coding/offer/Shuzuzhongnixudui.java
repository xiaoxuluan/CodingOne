package coding.offer;

public class Shuzuzhongnixudui {
	
	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,6,7,0};
		int i = 0;
		int count = 0;
		while(i<=a.length-1) {
			for(int j=1;j<a.length;j++){
			if(a[i]>a[j]) {
				count++;
				System.out.println(count);
				}
			}
			i++;
		}
		System.out.println(count%1000000007);
		System.out.println(7%1000000007);

	}

}
