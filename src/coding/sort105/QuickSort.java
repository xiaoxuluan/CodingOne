package coding.sort105;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/24 23:30
 * @Version 1.0
 */
public class QuickSort {

    public static void quickSort(int [] nums){
        if(nums.length>0){
            quickSortCore(nums,0,nums.length-1);
        }
    }

    private static void quickSortCore(int[] nums, int start, int end){

        //确定算法结束位置
        if(start>end){
            return;
        }

        int i = start;
        int j = end;

        int key = nums[start];

        while (i<j){
            while (i<j&&nums[j]>key){
                j--;
            }
            while (i<j&&nums[i]<=key){
                i++;
            }
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            int temp = nums[i];
            nums[i] = nums[start];
            nums[start] = temp;
            quickSortCore(nums,start,i-1);
            quickSortCore(nums,i+1,end);
        }
    }
}
