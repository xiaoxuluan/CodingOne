package coding2.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题  使用回溯法 进行解决
 *
 * @Author: alenlyx
 * @Date: 2019/7/27 18:56
 * @Version 1.0
 */
public class Leetcode46 {


    /**
     * 回溯法相关概念
     * 回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，
     * 当发现已不满足求解条件时，就“回溯”返回，尝试别的路径。
     * 回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，
     * 就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
     * 许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。
     *
     * @param nums nums
     * @return List<List < Integer>>
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList<>();

        ArrayList<Integer> nums_lst = new ArrayList<Integer>();

        for (int num : nums) {
            nums_lst.add(num);
        }

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    private void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {

        //
        if (first == n) {
            output.add(new ArrayList<Integer>(nums));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);

            backtrack(n, nums, output, first + 1);

            Collections.swap(nums, first, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(new Leetcode46().permute(nums));
    }
}
