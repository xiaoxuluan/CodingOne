package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/8/12 15:02
 * @Version 1.0
 */
public class Leetcode34 {
    /**
     * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
     * <p>
     * ����㷨ʱ�临�Ӷȱ�����?O(log n) ����
     * <p>
     * ��������в�����Ŀ��ֵ������?[-1, -1]��
     * <p>
     * ʾ�� 1:
     * <p>
     * ����: nums = [5,7,7,8,8,10], target = 8
     * ���: [3,4]
     * ʾ��?2:
     * <p>
     * ����: nums = [5,7,7,8,8,10], target = 6
     * ���: [-1,-1]
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