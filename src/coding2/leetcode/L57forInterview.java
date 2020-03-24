package coding2.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alenlyx
 * @Date: 2020/3/15 15:39
 * @Version 1.0
 */
public class L57forInterview {

    public static void main(String[] args) {
        int target = 15;
        L57forInterview l57forInterview = new L57forInterview();
        List<List<Integer>> result= l57forInterview.findContinuousSequencd(target);
        System.out.println(result);
    }

    public List<List<Integer>> findContinuousSequencd(int target){
        int i =1;
        int j=1;
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(i <= target /2){
            if(sum < target){
                sum += j;
                j++;
            }else if(sum > target){
                sum -= i;
                i++;
            }else {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k <j ; k++) {
                    list.add(k);
                }
                result.add(list);
                sum -= i;
                i++;
            }
        }
        return result;

    }
}
