package coding.sort;

public class RadixSort {
	//d��ʾ�������ж���λ
	public static void sort(int [] number,int d ) {
		int k = 0;
		int n  = 1;
		int m = 1;//���Ƽ�ֵ��������һλ
		int [] [] temp =new int [10][number.length];//����ĵ�һά��ʾ���ܵ�����0-9
		int [] order = new int[10];//����orderp[i]������ʾ��λ��i�����ĸ���
		while(m<=d) {
			for(int i=0;i<number.length;i++) {
				int lsd = ((number[i]/n)%10);
				temp[lsd][order[lsd]]=number[i];
				order[lsd]++;
			}
			for(int i=0;i<10;i++) {
				if(order[i]!=0)
					for(int j=0;j<order[i];j++) {
						number[k]=temp[i][j];
						k++;
					}
				order[i]=0;
			}
			n*=10;
			k=0;
			m++;
		}
	}
public static void main(String[] args) {
	int [] data = {1,9,45,66,23,85,49,77,150,120};
	for (int i = 0; i < data.length; i++) {
		System.out.print(data[i]+" ");	
		}
	System.out.println();
	RadixSort.sort(data, 3);
	for (int i = 0; i < data.length; i++) {
	System.out.print(data[i]+" ");	
	}
}
}
