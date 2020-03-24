package coding2.l2;

/**
 * @Author: alenlyx
 * @Date: 2020/3/21 16:08
 * @Version 1.0
 */
public class L209 {

    //长度最小的子数组
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        L209 l209 = new L209();
        int result = l209.minsubarray(5,nums);
        System.out.println(result);
    }

    //O(n)级别 双指针 构造滑动窗口
    // i不动 j++ sum> s 停止j
    //i移动 j不动 sum <s j++ sum>s i++ 直到最后
    public int minSubArrayLen(int s,int [] nums){
        int left = 0;
        int right =-1;
        int sum = 0;
        int result = nums.length+1;
        while( left < nums.length){
            if( right +1 < nums.length && sum <s){
                right++;
                sum += nums[right];
            }else{
                sum -= nums[left];
                left++;
            }

            if (sum >= s){
                if((right - left+1)>result){
                    result = result;
                }else {
                    result = right -left+1;
                }
            }
        }
        if(result == nums.length+1){
            return 0;
        }
        return result;
    }

    public int minsubarray(int s,int [] nums){
        int left = 0;
        int sum = 0;
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >=s){
                result = Math.min(result,i-left+1);
                sum -= nums[left++];
            }
        }

        return result;
    }
}
