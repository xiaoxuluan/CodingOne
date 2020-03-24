package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/7/29 15:51
 * @Version 1.0
 */
public class Leetcode55 {

    public static boolean canJump(int [] nums){
        int  i = 0,j= -1;
        while (i < nums.length-1&&i!=j){
            j = i;
            i = search(i,nums[i],nums);
        }

        return i>=nums.length-1?true:false;
    }

    public static int search(int i, int j, int[] nums) {

        int  t = 0;
        if(i + j <nums.length-1){
            t = i + j;
        }
        else {
            return nums.length - 1;
        }

        for (int k = i+1; k <= i + j &&  k<=nums.length-1;k++) {

            if(k + nums[k] >= i + j && k+nums[k]>=nums[t]+t){
                t = k;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println( Leetcode55.canJump(nums));

        int [] nums1 = {3,2,1,1,4};

        System.out.println( Leetcode55.canJump(nums1));

    }
}
