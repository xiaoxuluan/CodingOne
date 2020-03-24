package coding2.l2;

/**
 * @Author: alenlyx
 * @Date: 2020/3/21 16:08
 * @Version 1.0
 */
public class L209 {

    //������С��������
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        L209 l209 = new L209();
        int result = l209.minsubarray(5,nums);
        System.out.println(result);
    }

    //O(n)���� ˫ָ�� ���컬������
    // i���� j++ sum> s ֹͣj
    //i�ƶ� j���� sum <s j++ sum>s i++ ֱ�����
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
