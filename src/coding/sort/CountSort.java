package coding.sort;

public class CountSort {

    public static void main(String [] args) {
        int a[]={100,93,97,92,96,99,92,89,93,97,90,94,92,95};
        for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
			
		}
        System.out.println();
        int [] b = countSort(a);
        for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+" ");
			
		}
	}

	private static int[] countSort(int[] a) {
		// TODO Auto-generated method stub
		int b[] = new int [a.length];
		int max = a[0];
		int min = a[0];
		for(int i:a) {
			if(i>max) {
				max=i;
			}
			if(i<min) {
				min = i;
			}
		}
		int k =  max-min+1;
		int c[] = new int[k];
		for(int i=0;i<a.length;++i) {
			c[a[i]-min]+=1;
		}
		for(int i=1;i<c.length;++i) {
			c[i]=c[i]+c[i-1];
		}
		for(int i=a.length-1;i>=0;--i) {
			b[--c[a[i]-min]]=a[i];
		}
		return b;
	}

}
