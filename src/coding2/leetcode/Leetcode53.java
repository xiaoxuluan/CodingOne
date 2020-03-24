package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/10 15:19
 * @Version 1.0
 */
public class Leetcode53 {

    /**
     * 给定一个整数数组 nums?，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释:?连续子数组?[4,-1,2,1] 的和最大，为?6。
     *
     */


    /**
     *
     * 采用动态规划进行处理
     * @param nums
     * @return
     */
    public int maxSubArray(int [] nums){
        int ans = nums[0];
        int dp = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            //第一步 dp和下一个数字进行相加, 然后进行比较  dp+next > next ? 取最大的结果
            dp = Math.max(dp + nums[i],nums[i]);

            //dp计算出来的值 和结果进行比较
            ans = Math.max(ans,dp);
        }
        return ans;
    }

    /**
     * 采用for循环 非迭代遍历
     * @param nums
     * @return
     */
    public int maxSubArray2(int [] nums){
        int res = nums[0];
        int sum = 0;
        for(int num:nums){
            if(sum >0){
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(res,sum);
        }

        return res;
    }

    public static void main(String[] args) {
        int [] nums={1,-2,3,-4,-5,6};
        int result = new Leetcode53().maxSubArray(nums);
        int result2 = new Leetcode53().maxSubArray2(nums);
        System.out.println(result);
        System.out.println(result2);
    }
}
