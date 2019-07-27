package coding2.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: luanyanxu
 * @Date: 2019/7/27 19:57
 * @Version 1.0
 */
public class Leetcode47 {

    private List<List<Integer>> result = new ArrayList<>();

    private boolean[] used;
    /**
     * ����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
     *
     * ʾ��:
     *
     * ����: [1,1,2]
     * ���:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     */

    /*
    ���� ��֦
    ������

     */

    public List<List<Integer>> permuteUnique(int [] nums){
        int length = nums.length;
        if(length == 0){
            return  result;
        }

        Arrays.sort(nums);
        used = new boolean[length];

        findPremuteUnique(nums,0,new Stack<>());

        return  result;

    }

    private void findPremuteUnique(int[] nums, int depth, Stack<Integer> objects) {
        if(depth == nums.length){
            result.add(new ArrayList<>(objects));
            return;
        }

        for (int i = 0; i<nums.length;i++){
            if (!used[i]){
                if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                    continue;
                }

                used[i] = true;
                objects.add(nums[i]);
                findPremuteUnique(nums,depth+1,objects);
                objects.pop();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int [] nums = {1,1,2};
        System.out.println(new Leetcode47().permuteUnique(nums));
    }
}
