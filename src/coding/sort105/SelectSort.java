package coding.sort105;

public class SelectSort {
	public static void main(String[] args) {
		int[] s = { 1, 9, 8, 5, 6, 44, 23, 25, 47, 9654 };
		System.out.println("≈≈–Ú«∞");
		for (int i = 0; i < s.length-1; i++) {
			System.out.print(s[i] + " ");

		}
		selectSort(s);
		System.out.println();
		System.out.println("≈≈–Ú∫Û");
		for (int i = 0; i < s.length-1; i++) {
			System.out.print(s[i] + " ");

		}

	}

	private static void selectSort(int[] s) {
		// TODO Auto-generated method stub
		for(int i=0;i<s.length;i++) {
			int index = i;
			for(int j = index+1;j<s.length;j++) {
				if(s[index]>s[j]) {
					index  = j;
				}
			}
			if(i != index) {
				int temp = s[i];
				s[i] = s[index];
				s[index] = temp;
			}
		}
	}
}
