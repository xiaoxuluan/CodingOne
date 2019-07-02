package coding.sort;

public class SelectSort {
	
	public static void main(String[] args) {
		int [] data = {1,9,3,5,6,7,58,49,11,958,667};
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		selectSort(data);
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

	private static void selectSort(int[] data) {
		// TODO Auto-generated method stub
		for(int i = 0;i<data.length;i++) {
			int index = i;
			for(int j= index+1;j<data.length;j++) {
				if(data[index]>data[j]) {
					index = j;
				}
			}
			if( i != index) {
				swap(data,i,index);
			}
		}
	}

	private static void swap(int[] data, int i, int index) {
		// TODO Auto-generated method stub
		int  temp = data[i];
		data[i] = data[index];
		data[index] = temp;
	}

}
