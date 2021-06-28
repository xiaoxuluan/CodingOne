package coding.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yanxuluan
 */
public class Lianxushuzidehe {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //��Ž��
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //������㣬�൱�ڶ�̬���ڵ����ߣ������䴰���ڵ�ֵ�ĺ���ȷ�����ڵ�λ�úʹ�С
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //�����������ģ���Ϊ1��һ�����У���ô��͹�ʽ��(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //��ȣ���ô�ͽ����ڷ�Χ����������ӽ������
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;
                //�����ǰ�����ڵ�ֵ֮��С��sum����ô�ұߴ�������һ��
            } else if (cur < sum) {
                phigh++;
            } else {
                //�����ǰ�����ڵ�ֵ֮�ʹ���sum����ô��ߴ�������һ��
                plow++;
            }
        }
        return result;
    }

    public List<ArrayList<Integer>> findSub(int sum) {
        /**
         * aN = a1 + (n - 1) * d;
         * dΪ����
         * Sn = n(a1 + aN) / 2;
         * Sn = n*a1 + n(n-1)d/2;
         */

        //�������ڴ���
        List<ArrayList<Integer>> result = new ArrayList<>();
        //������������
        int low = 1, high = 2;
        while (high > low) {
            //    sum = n               *(a1 + an)   / 2;
            //int cur = (high - low + 1)*(low + high) / 2;
            int cur = (high + low) * (high - low + 1) / 2;
            //�����==sum
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++;
            } else if (cur < sum) {
                high++;
            } else {
                low++;
            }
        }
        return result;
    }

    public static List<List<Integer>> findSub2(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        int low = 1, high = 2;
        while (high > low) {
            int curSum = (high - low + 1) * (low + high) / 2;
            if (curSum == sum) {
                List<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                low++;
            } else if (curSum < sum) {
                high++;
            } else {
                low++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Lianxushuzidehe l = new Lianxushuzidehe();

        List<List<Integer>> list = new ArrayList<>();
        list = findSub2(150);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}