package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/9 15:26
 * @Version 1.0
 */
public class Leetcode41 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //定义一个新数组，最小的数字肯定就在新数组的下标中
        int[] arr = new int[len + 2];
        for (int item : nums) {
            //排除负数和大于输入数组长度的数，因为缺失的正数肯定小于数组的长度+1（这里需要仔细想清楚）
            if (item > 0 && item <= len) {
                //新数组下标为1，则表示有这个数字
                arr[item] = 1;
            }
        }

        //遍历新数组 看看第一个没有的正整数是谁就行了
        for (int i = 1; i < len + 2; i++) {
            if (0 == arr[i]) {
                return i;
            }
        }
        //这一步为了应对空数组
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(new Leetcode41().firstMissingPositive(nums));
    }
}
