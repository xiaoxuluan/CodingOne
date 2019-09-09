package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/9 15:26
 * @Version 1.0
 */
public class Leetcode41 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 2];
        for (int item : nums) {
            if (item > 0 && item <= len) {
                arr[item] = 1;
            }
        }
        for (int i = 1; i < len + 2; i++) {
            if (0 == arr[i]) {
                return i;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(new Leetcode41().firstMissingPositive(nums));
    }
}
