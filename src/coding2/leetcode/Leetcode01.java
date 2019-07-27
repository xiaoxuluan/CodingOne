package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/7/27 20:24
 * @Version 1.0
 */
public class Leetcode01 {
    /**
     * ����һ���������� nums��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ�����������������������ǵ������±ꡣ
     *
     * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
     *
     * ʾ��:
     *
     * ���� nums = [2, 7, 11, 15], target = 9
     *
     * ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
     * ���Է��� [0, 1]
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/two-sum
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     */

    public static void main(String[] args) {
        int [] nums = {1,3,5,9};
        int target = 10;
        int [] result = new int [2];
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }

    }


}
