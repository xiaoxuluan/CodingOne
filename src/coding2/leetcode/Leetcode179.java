package coding2.leetcode;

import java.util.Arrays;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/18 10:43
 * @Version 1.0
 */
public class Leetcode179 {
    /**
     * ����һ��Ǹ������������������ǵ�˳��ʹ֮���һ������������
     *
     * ʾ�� 1:
     *
     * ����: [10,2]
     * ���: 210
     * ʾ��?2:
     *
     * ����: [3,30,34,5,9]
     * ���: 9534330
     * ˵��: ���������ܷǳ�����������Ҫ����һ���ַ���������������
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/largest-number
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     * @param nums
     * @return
     */

    public String largestNumber(int [] nums){
        if(nums == null || nums.length == 0){
            return "";
        }
        //��������-���ַ����� ת��
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr,(o1,o2)->(o2+o1).compareTo(o1+o2));
        //�ַ����� -���ַ���  ת��
        StringBuilder sb = new StringBuilder();
        for (String aStrArr: strArr) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        //������� ���ɸ�0
        if(result.charAt(0) == '0'){
            result = "0";
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        String r1 = new Leetcode179().largestNumber(nums);
        System.out.println(r1);
    }


}
