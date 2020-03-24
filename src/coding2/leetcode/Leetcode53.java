package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/10 15:19
 * @Version 1.0
 */
public class Leetcode53 {

    /**
     * ����һ���������� nums?���ҵ�һ���������͵����������飨���������ٰ���һ��Ԫ�أ������������͡�
     *
     * ʾ��:
     *
     * ����: [-2,1,-3,4,-1,2,1,-5,4],
     * ���: 6
     * ����:?����������?[4,-1,2,1] �ĺ����Ϊ?6��
     *
     */


    /**
     *
     * ���ö�̬�滮���д���
     * @param nums
     * @return
     */
    public int maxSubArray(int [] nums){
        int ans = nums[0];
        int dp = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            //��һ�� dp����һ�����ֽ������, Ȼ����бȽ�  dp+next > next ? ȡ���Ľ��
            dp = Math.max(dp + nums[i],nums[i]);

            //dp���������ֵ �ͽ�����бȽ�
            ans = Math.max(ans,dp);
        }
        return ans;
    }

    /**
     * ����forѭ�� �ǵ�������
     * @param nums
     * @return
     */
    public int maxSubArray2(int [] nums){
        int res = nums[0];
        int sum = 0;
        for(int num:nums){
            if(sum >0){
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(res,sum);
        }

        return res;
    }

    public static void main(String[] args) {
        int [] nums={1,-2,3,-4,-5,6};
        int result = new Leetcode53().maxSubArray(nums);
        int result2 = new Leetcode53().maxSubArray2(nums);
        System.out.println(result);
        System.out.println(result2);
    }
}
