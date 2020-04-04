package coding2.leetcode;

import java.util.HashMap;

/**
 * @Author: luanyanxu
 * @Date: 2020/4/4 10:36
 * @Version 1.0
 */
public class L136 {

    public static void main(String[] args) {
        int [] nums = {1,1,2,2,4};

        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        System.out.println(ans);
        System.out.println(map.keySet());

    }

}

