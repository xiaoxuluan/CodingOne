package coding2.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: luanyanxu
 * @Date: 2019/8/28 15:25
 * @Version 1.0
 */
public class Leetcode40 {

    // residue ��ʾʣ�࣬���ֵһ��ʼ���� target��������Ŀ��˵����"�������֣�����Ŀ����������������"�������
    // residue �ڵݹ�����У�ֻ��Խ��ԽС
    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // ��һ��֮�����ܹ���Ч����ǰ��������һ�����ź���ģ��������ܱ�֤��
            // �ڵݹ���õ�ͳһ��ȣ��㣩�У�һ��Ԫ��ֻʹ��һ�Ρ�
            // ��һ����֦�������� candidates ���������������ǰ����
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // ���ؼ�����ΪԪ�ز������ظ�ʹ�ã�����ݹ鴫����ȥ���� i + 1 ������ i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // �Ƚ�����������һ���ܹؼ�
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Leetcode40 solution = new Leetcode40();
        List<List<Integer>> combinationSum2 = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }





}
