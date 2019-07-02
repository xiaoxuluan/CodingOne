package coding.sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] data = { 1, 9, 3, 5, 6, 7, 5, 4, 11, 9585, 66, 56 };
		System.out.print("≈≈–Ú«∞:");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		insertSort(data);
		System.out.println();
		System.out.print("≈≈–Ú∫Û:");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	private static void insertSort(int[] data) {
		// TODO Auto-generated method stub
		int temp;
		for (int i = 1; i < data.length; i++) {
			temp = data[i];
			int j = i;
			for (; j > 0 && temp < data[j - 1]; j--) {
				data[j] = data[j - 1];
			}
			data[j] = temp;
		}
	}
}
