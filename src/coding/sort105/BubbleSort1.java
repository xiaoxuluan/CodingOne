package coding.sort105;

/**
 * @Author: alenlyx
 * @Date: 2020/3/24 23:21
 * @Version 1.0
 */
public class BubbleSort1 {

    public static void main(String[] args) {
        int [] nums = {1,3,2,34,96,45,26,7,16};
        printNums(nums);
        bubbleSort(nums);
        System.out.println();
        printNums(nums);
    }
    // ±º‰∏¥‘”∂» O(N^2)
    public static void bubbleSort(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }

    public static void printNums(int [] nums){
        for (int i = 0; i < nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
