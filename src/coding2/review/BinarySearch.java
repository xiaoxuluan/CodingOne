package coding2.review;

/**
 * @Author: alenlyx
 * @Date: 2019/10/14 17:38
 * @Version 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int [] data = {1,2,3,6,9};
        int target = 3;



        int res = 0;

        int low = 0;
        int high = data.length;
        while(low <= high){
            int mid = (low+high)/2;
            if(target==data[mid]){
                res= mid;
            }else if(target<data[mid]){
                high = mid -1;
            }else{
                low = mid+1;
            }
        }

        System.out.println(res);
    }



}
