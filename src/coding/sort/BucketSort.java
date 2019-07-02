package coding.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		int[] data = { 1, 3, 7, 5, 9, 11, 15, 13, 222, 585, 1066 };
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		List<Integer> list = bucketSort(data);
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	private static List<Integer> bucketSort(int[] data) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < data.length; i++) {
			max = Math.max(max, data[i]);
			min = Math.min(min, data[i]);
		}
		// 计算桶数量
		int bucketNum = (max - min) / data.length + 1;
		ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new ArrayList<Integer>());
		}

		// 将每个元素放入桶
		for (int i = 0; i < data.length; i++) {
			int num = (data[i] - min) / (data.length);
			bucketArr.get(num).add(data[i]);
		}
		
		// 对每个桶进行排序
		for (int i = 0; i < bucketArr.size(); i++) {
			Collections.sort(bucketArr.get(i));
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < bucketArr.size(); i++) {
			if (null != bucketArr.get(i)) {
				for (int j = 0; j < bucketArr.get(i).size(); j++) {
					list.add(bucketArr.get(i).get(j));
				}
			}
		}

		return list;

	}
}
