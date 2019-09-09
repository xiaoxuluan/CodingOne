package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/8/12 14:57
 * @Version 1.0
 */
public class Leetcode33 {
    /**
     * ËÑË÷Ðý×ªÅÅÐòÊý×é
     *
     */
    int [] nums;
    int target ;
    public int find_rorate_index(int left,int right){
        if(nums[left] < nums[right]){
            return 0;
        }

        while (left <= right){
            int pivot = (left + right) /2;
            if(nums[pivot] > nums[pivot+1]){
                return pivot+1;
            }else {
                if (nums[pivot]< nums[left]){
                    right = pivot-1;
                }else {
                    left = pivot+1;
                }
            }
        }
        return 0;
    }

    public int search(int left,int right){
        while (left<=right){
            int pivot = (left+right)/2;
            if(nums[pivot] == target){
                return pivot;
            }else {
                if (target<nums[pivot]){
                    right = pivot + 1;
                }else {
                    left = pivot + 1;
                }
            }
        }
        return  -1;
    }

    public int searchnums(int [] nums,int target){
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if(n == 0){
            return -1;
        }
        if(n == 1){
            return this.nums[0] == target ? 0:-1;
        }

        int rorate_index = find_rorate_index(0,n-1);

        if(nums[rorate_index] == target){
            return rorate_index;
        }

        if(rorate_index == 0){
            return search(0,n-1);
        }

        if(target <nums[0]){
            return search(rorate_index,n-1);
        }

        return search(1,rorate_index);
    }

    public static void main(String[] args) {
        int [] nums={1,2,3,4,5,6,7,15,16};
        int target = 15;
        System.out.println(new Leetcode33().searchnums(nums,target));
    }
}
