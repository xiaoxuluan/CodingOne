package coding2.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/23 14:38
 * @Version 1.0
 */
public class Leetcode118 {
    /**
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <1){
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = Arrays.asList(new Integer[i+1]);
            list.set(0,1);
            list.set(i,1);
            for (int j = 1; j < i; j++) {
                //等于上一行 两个数之和
                list.set(j,result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new  Leetcode118().generate(5);
        System.out.println(lists);
    }

}
