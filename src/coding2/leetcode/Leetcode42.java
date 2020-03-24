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


         //�����ÿһ�������ߣ��ұ���ߵĸ߶�
         //���ÿһ�а���ˮ�εĸ�����Ϊ ������͵ĸ߶ȼ�ȥ��ǰ�߶�


        for(int i=1;i<n;i++){
            left[i] = Math.max(height[i],left[i-1]);

        }

        for(int i = n-2;i>=0;i--){
            right[i]= Math.max(height[i],right[i+1]);
        }

        //����ÿһ����ˮ�ε�����
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
