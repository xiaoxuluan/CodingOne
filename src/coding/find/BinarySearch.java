package coding.find;

/**
 * @author luanyanxu 
 * 2018��11��13��
 */
public class BinarySearch {

	// ѭ��ʵ��
	public static int binarySearch(int[] arr, int target) {
		// �����ʼ��С���������
		int low = 0;
		int high = arr.length - 1;
		// ȷ���������Խ��
		while (low <= high) {
			// �����м�����ֵ
			int middle = (low + high) / 2;// ��ֹ���
			if (target == arr[middle]) {
				return middle;
				// �ж�����
			} else if (target < arr[middle]) {
				high = middle - 1;
				// �ж�����
			} else {
				low = middle + 1;
			}
		}
		// ��û�У�����-1
		return -1;
	}

	// �ݹ�ʵ�ֶ��ֲ���
	public static int binarySearch1(int[] dataset, int target, int beginIndex, int endIndex) {
		int midIndex = (beginIndex + endIndex) / 2;
		if (target < dataset[beginIndex] || target > dataset[endIndex] || beginIndex > endIndex) {
			return -1;
		}
		if (target < dataset[midIndex]) {
			return binarySearch1(dataset, target, beginIndex, midIndex - 1);
		} else if (target > dataset[midIndex]) {
			return binarySearch1(dataset, target, midIndex + 1, endIndex);

		} else {
			return midIndex;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 6, 9, 12, 25, 36, 88, 45, 69, 85 };
		int target = 25;
		System.out.println(binarySearch(arr, target));
		System.out.println(binarySearch1(arr, target, 0, arr.length - 1));
	}

}
