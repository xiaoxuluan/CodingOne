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
     * 具有度数 d 的数组必须有一些元素 x 出现 d 次。如果某些子数组具有相同的度数，那么某些元素 x （出现 d 次）。最短的子数组是将从 x 的第一次出现到最后一次出现的数组。
     * 对于给定数组中的每个元素，让我们知道 left 是它第一次出现的索引； right 是它最后一次出现的索引。例如，当 nums = [1,2,3,2,5] 时，left[2] = 1 和 right[2] = 3。
     * 然后，对于出现次数最多的每个元素 x，right[x] - left[x] + 1 将是我们的候选答案，我们将取这些候选的最小值。
     *
     *
     */

    /**
     * 时间复杂度 O(N) 其中N是nums的长度 每个循环需要O(N)的时间
     * 空间复杂度：O(N) left right count 使用的空间
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
