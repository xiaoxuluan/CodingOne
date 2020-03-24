package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/9 15:26
 * @Version 1.0
 */
public class Leetcode41 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //����һ�������飬��С�����ֿ϶�������������±���
        int[] arr = new int[len + 2];
        for (int item : nums) {
            //�ų������ʹ����������鳤�ȵ�������Ϊȱʧ�������϶�С������ĳ���+1��������Ҫ��ϸ�������
            if (item > 0 && item <= len) {
                //�������±�Ϊ1�����ʾ���������
                arr[item] = 1;
            }
        }

        //���������� ������һ��û�е���������˭������
        for (int i = 1; i < len + 2; i++) {
            if (0 == arr[i]) {
                return i;
            }
        }
        //��һ��Ϊ��Ӧ�Կ�����
        return len + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(new Leetcode41().firstMissingPositive(nums));
    }
}
