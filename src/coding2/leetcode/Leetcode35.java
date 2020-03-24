package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/8/12 15:21
 * @Version 1.0
 */
public class Leetcode35 {
    /**
     * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
     *
     * ����Լ������������ظ�Ԫ�ء�
     *
     * ʾ�� 1:
     *
     * ����: [1,3,5,6], 5
     * ���: 2
     * ʾ��?2:
     *
     * ����: [1,3,5,6], 2
     * ���: 1
     *
     * @param nums
     * @param target
     * @return
     */

    public int searcheInsert(int [] nums,int target){
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>= target){
                return i;
            }
        }
        return nums.length;
    }


    public static void main(String[] args) {
        int  [ ] nums = {1,2,5,6,7,9};
        int target = 7;
        System.out.println(new Leetcode35().searcheInsert(nums,target));
    }
}
