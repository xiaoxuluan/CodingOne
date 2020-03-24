package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/9 19:02
 * @Version 1.0
 */
public class Leetcode485 {

    /**
     * ����һ�����������飬 ���������������1�ĸ�����
     *
     * ʾ�� 1:
     *
     * ����: [1,1,0,1,1,1]
     * ���: 3
     * ����: ��ͷ����λ��������λ��������1�������������1�ĸ����� 3.
     * ע�⣺
     *
     * ���������ֻ����?0 ��1��
     * ��������ĳ��������������Ҳ����� 10,000��
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/max-consecutive-ones
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     */

    public int findMaxConsecutiveOnes(int [] nums){
        int result = 0,num = 0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] == 1){
                num++;
            }else {
                result = num>result ? num:result;
                num = 0;
            }
        }

        return result>num?result:num;
    }

    public static void main(String[] args) {
        int [] nums = {1,1,0,1,1,1};

        System.out.println(new Leetcode485().findMaxConsecutiveOnes(nums));
    }

}
