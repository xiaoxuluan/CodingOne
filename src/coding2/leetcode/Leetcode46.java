package coding2.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ȫ��������  ʹ�û��ݷ� ���н��
 *
 * @Author: alenlyx
 * @Date: 2019/7/27 18:56
 * @Version 1.0
 */
public class Leetcode46 {


    /**
     * ���ݷ���ظ���
     * �����㷨ʵ����һ������ö�ٵ��������Թ��̣���Ҫ�����������Թ�����Ѱ������Ľ⣬
     * �������Ѳ������������ʱ���͡����ݡ����أ����Ա��·����
     * ���ݷ���һ��ѡ������������ѡ��������ǰ�������ԴﵽĿ�ꡣ����̽����ĳһ��ʱ������ԭ��ѡ�񲢲��Ż�ﲻ��Ŀ�꣬
     * ���˻�һ������ѡ�������߲�ͨ���˻����ߵļ���Ϊ���ݷ������������������ĳ��״̬�ĵ��Ϊ�����ݵ㡱��
     * ��ิ�ӵģ���ģ�ϴ�����ⶼ����ʹ�û��ݷ����С�ͨ�ý��ⷽ���������ơ�
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
