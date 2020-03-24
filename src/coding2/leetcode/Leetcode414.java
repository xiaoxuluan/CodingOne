package coding2.leetcode;

import java.util.TreeSet;

/**
 * @Author: alenlyx
 * @Date: 2019/9/9 18:32
 * @Version 1.0
 */
public class Leetcode414 {

    public int thirdMax(int [] nums){
        if(nums == null || nums.length == 0){
            throw  new RuntimeException("error");
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (Integer elme :nums){
            set.add(elme);
            if (set.size()>3){
                set.remove(set.first());
            }
        }

        return set.size()< 3?set.last():set.first();
    }

    public static void main(String[] args) {

        int [] nums = {1,2,3,4};
        System.out.println(new Leetcode414().thirdMax(nums));
    }
}