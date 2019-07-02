package coding.sort;

public class QuickSort {
	public static void main(String[] args) {
		int [] data = {1,9,3,5,6,7,569,4,11,9585,66,56};
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		quickSort(data);
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

	private static void quickSort(int[] data) {
		// TODO Auto-generated method stub
		if(data.length>0) {
			quickSortCore(data,0,data.length-1);
		}
	}

	private static void quickSortCore(int[] data, int low, int high) {
		// TODO Auto-generated method stub
		
		//1.找到算法出口
		if(low>high) {
			return;
		}
		//2.cun
		int i =low;
		int j = high;
		//3.key
		int key = data[low];
		//4.完成一趟排序
		while(i<j) {
			//4.1 从右往左找到第一个小于key的数
			while(i<j&&data[j]>key) {
				j--;
			}
			//4.2从右往左找到第一个大于key的数
			while(i<j&&data[i]<=key) {
				i++;
			}
			//4.3交换
			if(i<j) {
				int p =data[i];
				data[i]=data[j];
				data[j]=p;
			}
			
		}
		
		int temp = data[i];
		data[i]=data[low];
		data[low]=temp;
		quickSortCore(data, low, i-1);
		quickSortCore(data, i+1, high);
		
	}

	
	
}
