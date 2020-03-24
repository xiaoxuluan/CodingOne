package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/26 9:51
 * @Version 1.0
 */
public class Leetcode922 {
    /**
     * ����һ���Ǹ���������?A�� A ��һ��������������һ��������ż����
     *
     * ��������������Ա㵱?A[i] Ϊ����ʱ��i?Ҳ����������?A[i]?Ϊż��ʱ�� i Ҳ��ż����
     *
     * ����Է����κ���������������������Ϊ�𰸡�
     *
     * ?
     *
     * ʾ����
     *
     * ���룺[4,2,5,7]
     * �����[4,5,2,7]
     * ���ͣ�[4,7,2,5]��[2,5,4,7]��[2,7,4,5] Ҳ�ᱻ���ܡ�
     * ?
     *
     * ��ʾ��
     *
     * 2 <= A.length <= 20000
     * A.length % 2 == 0
     * 0 <= A[i] <= 1000
     *
     * @param nums
     */

    public int[] sortArrayByParityII(int [] nums){
        int odd = 0;
        int even = 1;
        int [] nums1 = new int [nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                nums1[odd]=nums[i];
                odd+=2;
            }else {
                nums1[even] = nums[i];
                even+=2;
            }
        }
        return nums1;
    }
    public static void main(String[] args) {

        int [] nums = {1,2,3,4,5,6,7,8};
        int [] result = new Leetcode922().sortArrayByParityII(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] +" ");
        }
    }
}
