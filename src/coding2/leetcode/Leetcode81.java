package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/10/15 18:19
 * @Version 1.0
 */
public class Leetcode81 {

    public boolean search(int [] nums,int target){
        if(nums == null || nums.length ==0){
            return false;
        }

        int start = 0;
        int end = nums.length-1;
        int mid;
        while (start<=end){
            mid = start + (end-start)/2;
            if(nums[mid]==target){
                return true;
            }

            if(nums[start]==nums[mid]){
                start++;
                continue;
            }

            //ǰ�벿������
            if(nums[start]<nums[mid]){
                //target��ǰ�벿��
                if(nums[mid]>target && nums[start]<=target){
                    end =mid-1;
                }else {
                    //����ȥ��벿����
                    start=mid+1;
                }
            }else {

                //�� �벿������
                //target�ں�벿��
                if(nums[mid]<target&& nums[end]>=target){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        int [] nums ={4,5,6,1,2,3};
        int target = 2;
        System.out.println(new Leetcode81().search(nums,target));
    }
}
