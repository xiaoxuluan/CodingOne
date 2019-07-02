package coding.sort105;

public class BubbleSort {

	public static void main(String[] args) {
		int[] s1 = { 1, 9, 8, 5, 6, 44, 23, 25, 47, 9654 };
		System.out.println("≈≈–Ú«∞");
		for (int i = 0; i < s1.length-1; i++) {
			System.out.print(s1[i] + " ");

		}
		bubbleSort(s1);
		System.out.println();
		System.out.println("≈≈–Ú∫Û");
		for (int i = 0; i < s1.length-1; i++) {
			System.out.print(s1[i] + " ");

		}

	}

	private static void bubbleSort(int[] s1) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s1.length-1; i++) {
			for (int j = i; j < s1.length-1; j++) {
				if (s1[j] > s1[j + 1]) {
					int temp = s1[j];
					s1[j] = s1[j + 1];
					s1[j + 1] = temp;
				}
			}
		}
	}

}
