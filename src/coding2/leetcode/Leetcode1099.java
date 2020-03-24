package coding2.leetcode;

import java.util.Arrays;

/**
 * @Author: alenlyx
 * @Date: 2019/9/16 13:48
 * @Version 1.0
 */
public class Leetcode1099 {
    /**
     * 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
     *
     * 如不存在这样的两个元素，请返回 -1。
     *
     * 示例 1：
     *
     * 输入：A = [34,23,1,24,75,33,54,8], K = 60
     * 输出：58
     * 解释：
     * 34 和 24 相加得到 58，58 小于 60，满足题意。
     * 示例 2：
     *
     * 输入：A = [10,20,30], K = 15
     * 输出：-1
     * 解释：
     * 我们无法找到和小于 15 的两个元素。
     * 提示：
     *
     * 1 <= A.length <= 100
     *
     * 1 <= A[i] <= 1000
     *
     * 1 <= K <= 2000
     *
     * 题目解析
     * 传统的 TwoSum 都是要你找到等于 target 的配对，那么如果说要找到 大于/小于 target 的配对呢？
     *
     * 这个时候 Hash 表的方法就很难 work 了，因为 Hash 表比较适合处理 等于 的情况 ！
     *
     * 那么就需要考虑如何使用排序加双指针的方法来解决这个问题，这里，题目是要求小于 target 的数量，我们还是按照之前的分析思路来分析。
     *
     * 如果说当前左右指针指向的元素的和大于或者等于 target，那么势必我们需要向左移动右指针，让两个元素的和尽可能地小。
     *
     * 当前头尾指针指向的元素和小于 target 的时候，这时我们需要记录答案，虽然这道题目里面没提，如果说要记录配对数量的话，这时并不是记录一个答案，如果说当前左指针固定，除了当前的右指针指向的元素，在左指针和右指针之间的数都是满足要求的，我们只需要加上这个区间的数量即可。
     *
     * 当然如果数组中存在重复元素，那么我们就需要按照之前的套路遍历去重了，当然对于这道题来说，我们选择满足条件的最大值即可。
     * @param nums
     * @param k
     * @return
     */

    public int twoSumLessThanK(int [] nums,int k){
        if(nums == null || nums.length == 0){
            return -1;
        }

        Arrays.sort(nums);
        int l = 0,r=nums.length-1;
        int result  = Integer.MIN_VALUE;
        while (l<r){
            if(nums[l]+nums[r]>=k){
                r--;
            }else {
                result = Math.max(result,nums[l]+nums[r]);
                l++;
            }
        }
        return result == Integer.MIN_VALUE ? -1:result;
    }
}
