package coding2.leetcode;

import java.util.HashSet;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/9 17:21
 * @Version 1.0
 */
public class Leetcode219 {
    /**
     * ����һ�����������һ������?k���ж��������Ƿ����������ͬ������?i?��?j��ʹ��?nums [i] = nums [j]������ i �� j?�Ĳ�ľ���ֵ���Ϊ k��
     *
     * ʾ��?1:
     *
     * ����: nums = [1,2,3,1], k = 3
     * ���: true
     * ʾ�� 2:
     *
     * ����: nums = [1,0,1,1], k = 1
     * ���: true
     * ʾ�� 3:
     *
     * ����: nums = [1,2,3,1,2,3], k = 2
     * ���: false
     *
     * ��Դ�����ۣ�LeetCode��
     * ���ӣ�https://leetcode-cn.com/problems/contains-duplicate-ii
     * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
     * @param nums
     * @param k
     * @return
     */

    public boolean containsNearbyDuplicate(int [] nums,int k){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }

            set.add(nums[i]);

            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }

        return false;
    }


}
