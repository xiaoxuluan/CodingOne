package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/10 13:00
 * @Version 1.0
 */
public class Leetcode62 {

    /**
     * ������ R ��ʾ���ң�D ��ʾ���£�Ȼ�������·��д�������ͻᷢ������������ˡ�
     *
     * R R R D D
     *
     * R R D D R
     *
     * R D R D R
     *
     * ����
     *
     * �����Ͻǣ������½ǣ��ܻ��� 3 �� R��2 �� D��ֻ�ǳ��ֵ�˳��һ����������ⷨ���������������������N = m + n - 2��Ҳ�����ܹ��ߵĲ����� k = m - 1��Ҳ�������µĲ�����D �ĸ����������ܹ��Ľ���� C^k_n = n!/(k!(n-k)!) = (n*(n-1)*(n-2)*...(n-k+1))/k!C
     * n
     * k
     * ?
     *  =n!/(k!(n?k)!)=(n?(n?1)?(n?2)?...(n?k+1))/k!��
     *
     *
     */

    public int uniquePaths(int m ,int n){
        int N = n+m-2;
        int k = m-1;
        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (N-k+i)/i;
        }

        return (int) result;
    }


}
