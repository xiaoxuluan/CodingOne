package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/24 23:56
 * @Version 1.0
 */
public class Leetcode26 {
    //给定排序数组，O(1)空间复杂度 移除数组中重复的元素
    public static int removeDuplicates(int [] nums){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,1,22,22,30};
        System.out.println(removeDuplicates(nums));
    }
}
