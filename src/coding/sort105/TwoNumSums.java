package coding.sort105;

import java.util.HashMap;
import java.util.Map;

import static coding.sort105.BubbleSort1.printNums;

/**
 * @Author: alenlyx
 * @Date: 2020/3/24 23:38
 * @Version 1.0
 */
public class TwoNumSums {

    public static int[] twoSum(int [] nums,int taregt){
        int [] s = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==taregt){
                    s[0]=i;
                    s[1]=j;
                }
            }
        }
        return s;
    }

    public static int[] twoSum1(int [] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)  && map.get(complement) !=i){
                return new int[]{i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two num solution");
    }

    public static void main(String[] args) {
        int [] nums = {2,7,11,91};
        int [] nums1 = twoSum(nums,9);
        printNums(nums1);
        int [] nums2 = twoSum1(nums,9);
        printNums(nums2);
    }
}
