package coding2.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alenlyx
 * @Date: 2019/9/23 14:51
 * @Version 1.0
 */
public class Leetcode119 {



    public List<Integer> getrow(int rownums){
        List<Integer> result = new ArrayList<>(rownums+1);
        long index = 1;
        for (int i = 0; i <= rownums; i++) {
            result.add((int) index);
            index = index * (rownums - i) / (i+1);
        }
        return result;
    }


    public static void main(String[] args) {

        List<Integer > list = new Leetcode119().getrow(3);
        System.out.println(list);
    }
}
