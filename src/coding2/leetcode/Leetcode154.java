package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/17 23:57
 * @Version 1.0
 */
public class Leetcode154 {
    /**
     * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
     *
     * ( ���磬����?[0,1,2,4,5,6,7] ���ܱ�Ϊ?[4,5,6,7,0,1,2]?)��
     *
     * ���ҳ�������С��Ԫ�ء�
     *
     * ע�������п��ܴ����ظ���Ԫ�ء�
     *
     * ʾ�� 1��
     *
     * ����: [1,3,5]
     * ���: 1
     * ʾ��?2��
     *
     * ����: [2,2,2,0,1]
     * ���: 0
     * @param nums
     * @return
     */

    //�������

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
