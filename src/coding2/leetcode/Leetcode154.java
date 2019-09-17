package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/17 23:57
 * @Version 1.0
 */
public class Leetcode154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else if (nums[mid] < nums[right]) right = mid;
            else right = right - 1;
        }
        return nums[left];




    }
}
