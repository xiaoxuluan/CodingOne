package coding.sort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] data = { 1, 9, 3, 5, 6, 7, 5, 4, 11 };
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		bubbleSort(data);
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	private static void bubbleSort(int[] data) {
		int temp;
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i] > data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}

			}
		}

	}
}
