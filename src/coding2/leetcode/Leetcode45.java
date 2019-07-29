package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/7/29 15:29
 * @Version 1.0
 */
public class Leetcode45 {

    public int jump(int [] nums){
        int end = 0;
        int maxPosition = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition,nums[i]+i);

            if(i == end){
                end = maxPosition;
                steps++;
            }
        }

        return steps;
    }


    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        System.out.println(new Leetcode45().jump(nums));
    }
}
