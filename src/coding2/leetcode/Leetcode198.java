package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2020/3/14 22:35
 * @Version 1.0
 */
public class Leetcode198 {

    public static void main(String[] args) {
        int [] nums = {1,3,5,7,9};
        int prevMax = 0;
        int currMax = 0;
        for(int x : nums){
            int temp = currMax;
            currMax = Math.max(prevMax+x,currMax);
            prevMax = temp;
        }
        //System.out.println(currMax);
        Leetcode198 leetcode198 = new Leetcode198();
        int result = leetcode198.rob(nums);
        System.out.println(result);

    }

    //一种更好的解法
    public  int rob(int [] nums){
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[len];
    }
}
