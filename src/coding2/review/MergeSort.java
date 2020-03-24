package coding2.review;

/**
 * @Author: alenlyx
 * @Date: 2019/9/14 19:34
 * @Version 1.0
 */
public class MergeSort {


    public int[] mergeSort(int [] nums,int l,int h){
        if( l == h){
            return new int[] { nums[l] };
        }
        int mid = l+(h-l)/2;
        int [] left = mergeSort(nums,l,mid);
        int [] right = mergeSort(nums,mid+1,h);
        int [] numresult = new int[left.length+right.length];
        int m=0,i=0,j=0;
        while (i<left.length && j<right.length){
            numresult[m++] = left[i]<right[j]?left[i++]:right[j++];
        }
        while (i<left.length){
            numresult[m++] = left[i++];
        }
        while (j<right.length){
            numresult[m++]=right[j++];
        }
        return numresult;

    }

    public static void main(String[] args) {
        int [] nums = {1,5,3,4,6,2,11,98};
        int [] nums1=new MergeSort().mergeSort(nums,0,nums.length-1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
