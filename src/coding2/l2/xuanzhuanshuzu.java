package coding2.l2;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/23 19:48
 * @Version 1.0
 */
public class xuanzhuanshuzu {

    public int fingMin(int [] nums){
        int left = 0,right = nums.length-1;
        if(nums[right]> nums[left]){
            return nums[left];
        }

        while (left <right&& right-left>1){
            int mid = left +(right -left)/2;
            if(nums[mid]>nums[left]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return Math.min(nums[left],nums[right]);


    }
}
