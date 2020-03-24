package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/17 23:57
 * @Version 1.0
 */
public class Leetcode154 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组?[0,1,2,4,5,6,7] 可能变为?[4,5,6,7,0,1,2]?)。
     *
     * 请找出其中最小的元素。
     *
     * 注意数组中可能存在重复的元素。
     *
     * 示例 1：
     *
     * 输入: [1,3,5]
     * 输出: 1
     * 示例?2：
     *
     * 输入: [2,2,2,0,1]
     * 输出: 0
     * @param nums
     * @return
     */

    //解决方案

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {6, 7, 8, 1, 2, 5};
        int result = new Leetcode154().findMin(nums);
        System.out.println(result);
    }
}
