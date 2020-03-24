package coding2.leetcode;

import java.util.Stack;

/**
 * @Author: alenlyx
 * @Date: 2019/8/9 15:38
 * @Version 1.0
 */
public class Leetcode32 {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(!stack.empty()&&stack.peek()=='('){
                stack.pop();
            }else {
                return false;
            }
        }

        return stack.empty();
    }

    public int longestValidParentheses(String s){
        int maxlen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j <= s.length() ; j+=2) {
                if(isValid(s.substring(i,j))){
                    maxlen = Math.max(maxlen,j-i);
                }
            }
        }
        return maxlen;
    }


    /**
     * 1.���Ƚ�-1 ����ջ��
     * ����������ÿ�������������ǽ������±����ջ��
     * ����������ÿ��")",���ǵ���ջ����Ԫ�� ������ǰԪ�ص��±��뵯��Ԫ�ص��±�����
     * �ó���ǰ��Ч�����ַ����ĳ���
     *
     * ʱ�临�Ӷ� O(N)
     * �ռ临�Ӷ� O��N��
     * @param s
     * @return
     */
    public int longestValidParenthesesl(String s){
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else{
                    maxans = Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }



    public static void main(String[] args) {

        System.out.println(new Leetcode32().longestValidParentheses("((()))"));
        System.out.println(new Leetcode32().longestValidParenthesesl("((()))"));
    }
}
