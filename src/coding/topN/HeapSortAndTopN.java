package coding.topN;

import java.util.Arrays;

public class HeapSortAndTopN {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        new HeapSortAndTopN().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] a) {
        int len = a.length;
        int firstNonLeafIndex = (len - 2)/2;

        for(int i = firstNonLeafIndex; i >=0 ; i --) {
            maxHeapify(a,len,i);
        }

        for(int j = len - 1; j > 0 ; j --) {
            swap(a,j,0);
            maxHeapify(a,j,0);
        }
    }

    private void maxHeapify(int[] a, int len, int subTreeNodeMax) {
        int left = subTreeNodeMax * 2 + 1;
        int right = subTreeNodeMax * 2 + 2;
        int maxIndex = subTreeNodeMax;
        if(left < len && a[left] > a[maxIndex]) {
            maxIndex = left;
        }
        if(right < len && a[right] > a[maxIndex]) {
            maxIndex = right;
        }
        if(maxIndex != subTreeNodeMax) {
            swap(a, maxIndex, subTreeNodeMax);
            maxHeapify(a, len, maxIndex);
        }
    }

    private void minHeapify(int[] a, int len, int subTreeNodeMax) {
        int left = subTreeNodeMax * 2 + 1;
        int right = subTreeNodeMax * 2 + 2;
        int maxIndex = subTreeNodeMax;
        if(left < len && a[left] < a[maxIndex]) {
            maxIndex = left;
        }
        if(right < len && a[right] < a[maxIndex]) {
            maxIndex = right;
        }
        if(maxIndex != subTreeNodeMax) {
            swap(a, maxIndex, subTreeNodeMax);
            maxHeapify(a, len, maxIndex);
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int[] topN(int[] array) {
        if(array != null && array.length > 0) {
            int arrayLen = array.length;
            int firtNonLeafIndex = (arrayLen - 2) / 2;
            for(int i = firtNonLeafIndex; i >= 0 ; i --) {
                minHeapify(array, arrayLen, i);
            }
        }
        return array;
    }

}

