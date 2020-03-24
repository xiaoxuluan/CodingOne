package coding2.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alenlyx
 * @Date: 2019/9/10 14:27
 * @Version 1.0
 */
public class Leetcode697 {

    /**
     * ���ж��� d �����������һЩԪ�� x ���� d �Ρ����ĳЩ�����������ͬ�Ķ�������ôĳЩԪ�� x ������ d �Σ�����̵��������ǽ��� x �ĵ�һ�γ��ֵ����һ�γ��ֵ����顣
     * ���ڸ��������е�ÿ��Ԫ�أ�������֪�� left ������һ�γ��ֵ������� right �������һ�γ��ֵ����������磬�� nums = [1,2,3,2,5] ʱ��left[2] = 1 �� right[2] = 3��
     * Ȼ�󣬶��ڳ��ִ�������ÿ��Ԫ�� x��right[x] - left[x] + 1 �������ǵĺ�ѡ�𰸣����ǽ�ȡ��Щ��ѡ����Сֵ��
     *
     *
     */

    /**
     * ʱ�临�Ӷ� O(N) ����N��nums�ĳ��� ÿ��ѭ����ҪO(N)��ʱ��
     * �ռ临�Ӷȣ�O(N) left right count ʹ�õĿռ�
     * @param nums
     * @return
     */

    public int findShortestSubArray(int [] nums){
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(left.get(x) == null){
                left.put(x,i);
            }
            right.put(x,i);
            count.put(x,count.getOrDefault(x,0)+1);
        }

        int ans = nums.length;

        int degree = Collections.max(count.values());
        for (int x:count.keySet()) {
            if(count.get(x) == degree){
                ans = Math.min(ans,right.get(x)- left.get(x)+1);
            }
        }

        return ans;
    }
}
