package coding.find;

/**
 * @author luanyanxu 
 * 2018年11月13日
 */
public class BinarySearch {

	// 循环实现
	public static int binarySearch(int[] arr, int target) {
		// 定义初始最小，最大索引
		int low = 0;
		int high = arr.length - 1;
		// 确保不会出现越界
		while (low <= high) {
			// 计算中间索引值
			int middle = (low + high) / 2;// 防止溢出
			if (target == arr[middle]) {
				return middle;
				// 判断下限
			} else if (target < arr[middle]) {
				high = middle - 1;
				// 判断上限
			} else {
				low = middle + 1;
			}
		}
		// 若没有，返回-1
		return -1;
	}

	// 递归实现二分查找
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
