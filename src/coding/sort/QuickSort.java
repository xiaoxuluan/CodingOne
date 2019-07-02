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
		
		//1.�ҵ��㷨����
		if(low>high) {
			return;
		}
		//2.cun
		int i =low;
		int j = high;
		//3.key
		int key = data[low];
		//4.���һ������
		while(i<j) {
			//4.1 ���������ҵ���һ��С��key����
			while(i<j&&data[j]>key) {
				j--;
			}
			//4.2���������ҵ���һ������key����
			while(i<j&&data[i]<=key) {
				i++;
			}
			//4.3����
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
