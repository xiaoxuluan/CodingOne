package coding.sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] data = { 1, 9, 3, 5, 6, 7, 5, 4, 11, 95, 66, 56 };
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		shellSort(data);
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

	private static void shellSort(int[] data) {
		// TODO Auto-generated method stub
		int k;
		for (int i = data.length / 2; i > 0; i /= 2) {

			for (int j = i; j < data.length; j++) {
				int temp = data[j];
				for (k = j; k >= i && temp < data[k - i]; k -= i) {
					data[k] = data[k - i];
				}
				data[k] = temp;
			}

		}
	}
}
