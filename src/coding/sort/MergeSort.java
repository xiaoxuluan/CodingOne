package coding.sort;

public class MergeSort {
	public static void main(String[] args) {
		int [] data = {1,9,3,5,6,7,51,4,11,95,66,56};
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		mergeSort(data);
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

	private static void mergeSort(int[] data) {
		// TODO Auto-generated method stub
		int [] temp = new int [data.length];
		merge0(data,temp,0,data.length-1) ;
	}

	private static void merge0(int[] data, int[] temp, int left, int right) {
		// TODO Auto-generated method stub
		if(left<right) {
			int center = (left + right) / 2;
			merge0(data,temp,left,center);
			merge0(data,temp,center+1,right);
			mergeSort(data,temp,left,center,right);
			
		}
	}

	private static void mergeSort(int[] data, int[] temp, int left, int center, int right) {
		// TODO Auto-generated method stub
		int leftEnd = center;
		int rightStart = center+1;
		int len =  right-left+1;
		int tempPos =  left;
		
		while(left <= leftEnd&&rightStart<=right) {
			if(data[left]<=data[rightStart]) {
				temp[tempPos++] = data[left++];
			}else {
				temp[tempPos++] = data[rightStart++];
			}
		}
		
		while(left<=leftEnd) {
			temp[tempPos++]=data[left++];
		}
		
		while(rightStart<=right) {
			temp[tempPos++]=data[rightStart++];
		}
		
		for(int i=0;i<len;i++,right--) {
			data[right] = temp[right];
		}
	}

}
