package coding2.review;

/**
 * @Author: alenlyx
 * @Date: 2019/10/15 21:17
 * @Version 1.0
 */
public class L33 {

    public int findIndex(int [] nums,int key){
        int left = 0;
        int right = nums.length-1;
        int mid = left+(right-left)/2;

        while (left<=right){
            if(nums[mid]== key){
                return mid;
            }else if (nums[left]<nums[mid]&& (nums[mid]>key||nums[left]>key)){

                left =mid-1;
            }else if(nums[mid]>key&&nums[left]<key){
                left= mid-1;
            }else if(nums[left]>nums[mid]){
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums ={4,5,6,1,2,3};
        int key = 2;
        int res= new L33().findIndex(nums,key);
        System.out.println(res);
    }
}
