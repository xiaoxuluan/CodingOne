package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/8/12 15:02
 * @Version 1.0
 */
public class Leetcode34 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是?O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回?[-1, -1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例?2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */

    private int extremInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;

            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, 1};
        int leftIdx = extremInsertionIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremInsertionIndex(nums, target, false) - 1;

        return targetRange;

    }

    public static void main(String[] args) {
        int [] nums = {1,2,5,5,8};

        int [] result = new Leetcode34().searchRange(nums,5);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}