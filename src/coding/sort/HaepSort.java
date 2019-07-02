package coding.sort;

public class HaepSort {
	public static void main(String[] args) {
		int [] data = {1,9,3,11,95,66,56};
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println(7/2);
		heapSort(data);
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]+" ");
		}
	}

	private static void heapSort(int[] data) {
		// TODO Auto-generated method stub
		for(int i =data.length/2;i>=0;i--) {
			buildHeap(data,i,data.length);
		}
		for(int i =data.length-1;i>=0;i--) {
			swap(data,0,i);
			buildHeap(data, 0, i);
		}
	}

	private static void swap(int[] data, int i, int i2) {
		// TODO Auto-generated method stub
		for (int  j= 0;  j< data.length; j++) {
			System.out.print(data[j]+" ");
		}
		int temp = data[i];
		data[i] = data[i2];
		data[i2] = temp;
		System.out.println();
	}

	private static void buildHeap(int[] data, int i, int length) {
		// TODO Auto-generated method stub
		int leftChild = leftChild(i);
		int temp =data[i];
		for(;leftChild<length;) {
			if(leftChild!=length-1&&data[leftChild]<data[leftChild+1]) {
				leftChild++;
			}
			if(temp<data[leftChild]) {
				data[i] = data[leftChild];
			}else {
				//break两个节点逗比父节点小，父节点大于儿子节点，直接停止比较，减小比较的次数
				break;
			}
			i=leftChild;
			leftChild = leftChild(i);
		}
		data[i] = temp;
	}

	//返回节点i的左儿子的index
	private static int leftChild(int i) {
		// TODO Auto-generated method stub
		return 2*i+1;
	}
}
