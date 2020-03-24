package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/5 14:16
 * @Version 1.0
 */
public class Leetcode42 {

    private int trap(int[] height){

        int n = height.length,sum = 0;
        if( n == 0){
            return 0;
        }
        int [] left = new int[n];
        int [] right = new int [n];
        left[0] = height[0];
        right[n-1] = height[n-1];


         //计算出每一列左边最高，右边最高的高度
         //最后每一列包含水滴的个数即为 两边最低的高度减去当前高度


        for(int i=1;i<n;i++){
            left[i] = Math.max(height[i],left[i-1]);

        }

        for(int i = n-2;i>=0;i--){
            right[i]= Math.max(height[i],right[i+1]);
        }

        //计算每一列中水滴的数量
        for(int i = 0;i<n;i++){
            sum+=Math.min(left[i],right[i]) - height[i];
           // System.out.println(Math.min(left[i],right[i])-height[i]);u-9ijjj-ijij-oij

        }
        return sum;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new Leetcode42().trap(nums));
    }
}
