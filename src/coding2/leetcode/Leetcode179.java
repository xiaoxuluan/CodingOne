package coding2.leetcode;

import java.util.Arrays;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/18 10:43
 * @Version 1.0
 */
public class Leetcode179 {
    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: 210
     * 示例?2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */

    public String largestNumber(int [] nums){
        if(nums == null || nums.length == 0){
            return "";
        }
        //数字数组-》字符数组 转化
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArr,(o1,o2)->(o2+o1).compareTo(o1+o2));
        //字符数组 -》字符串  转化
        StringBuilder sb = new StringBuilder();
        for (String aStrArr: strArr) {
            sb.append(aStrArr);
        }
        String result = sb.toString();
        //特殊情况 若干个0
        if(result.charAt(0) == '0'){
            result = "0";
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        String r1 = new Leetcode179().largestNumber(nums);
        System.out.println(r1);
    }


}
