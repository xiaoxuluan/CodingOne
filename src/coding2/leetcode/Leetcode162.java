package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/15 15:48
 * @Version 1.0
 */
public class Leetcode162 {

    /**
     * ��ֵԪ����ָ��ֵ������������ֵ��Ԫ�ء�
     *
     * ����һ����������?nums������ nums[i] �� nums[i+1]���ҵ���ֵԪ�ز�������������
     *
     * ������ܰ��������ֵ������������£������κ�һ����ֵ����λ�ü��ɡ�
     *
     * ����Լ���?nums[-1] = nums[n] = -�ޡ�
     *
     * ʾ�� 1:
     *
     * ����: nums = [1,2,3,1]
     * ���: 2
     * ����: 3 �Ƿ�ֵԪ�أ���ĺ���Ӧ�÷��������� 2��
     * ʾ��?2:
     *
     * ����: nums = [1,2,1,3,5,6,4]
     * ���: 1 �� 5
     * ����: ��ĺ������Է������� 1�����ֵԪ��Ϊ 2��
     * ?    ���߷������� 5�� ���ֵԪ��Ϊ 6��
     *
     */

    public int findPeakElement(int [] nums ){
        int l = 0,r = nums.length-1;
        while (l<r){
            int mid = (l+r)/2;
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }else{
                l = mid+1;
            }

        }
        return l;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,1,3,5,6,4};
        int result = new Leetcode162().findPeakElement(nums);
        System.out.println(result);
    }
}
