package coding.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Huadongchuangkouzuidazhi {
	// 求滑动窗口最大值
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> list = new ArrayList<>();
		if (num == null || num.length == 0 || size ==0) {
			return list;
		}
		ArrayList<Integer> list3 = new ArrayList<>();
		int len = num.length;

		int end = len - 1;
		if (size > len) {
			return list3;
		} else if (size == len) {
			Arrays.sort(num);
			list3.add(num[num.length-1]);
			return list3;
		} else {
			for (int i = 0; i < len; i++) {

				int idx = i;
				end = idx + size - 1;
				if (end >= len) {
					break;
				} else {
					for (int j = idx; j <= end; j++) {
						list.add(num[j]);
					}
					Collections.sort(list);
					list3.add(list.get(size - 1));
					list = new ArrayList<>();
				}
			}

		}
		System.out.println(list3);
		return list3;

	}

	public static void main(String[] args) {
		int[] num = { 2, 3, 4, 2, 6, 2, 5, 1 };
		Huadongchuangkouzuidazhi h = new Huadongchuangkouzuidazhi();
		h.maxInWindows(num, 0);
	}

}
