package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/23 14:02
 * @Version 1.0
 */
public class Leetcode209 {
    /**
     * 长度最小的子数组
     */

    public int minnumsLength(int [] nums ,int key){
        int l = 0,r = -1;
        int sum = 0;
        int result = nums.length+1;
        while (l<nums.length){
            if(r+l <nums.length && sum<key){
                r++;
                sum+=nums[r];
            }else{
                sum-=nums[l];
                l++;
            }

            if(sum >= key){
                result = (r-l+1)<result?(r-l+1):result;
            }
        }

        if(result == nums.length+1){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int length = new Leetcode209().minnumsLength(nums,5);
        System.out.println(length);
    }
}
