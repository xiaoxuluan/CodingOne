package coding.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yanxuluan
 */
public class Lianxushuzidehe {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                phigh++;
            } else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }

    public List<ArrayList<Integer>> findSub(int sum) {
        /**
         * aN = a1 + (n - 1) * d;
         * d为公差
         * Sn = n(a1 + aN) / 2;
         * Sn = n*a1 + n(n-1)d/2;
         */

        //滑动窗口处理
        List<ArrayList<Integer>> result = new ArrayList<>();
        //窗口左右两侧
        int low = 1, high = 2;
        while (high > low) {
            //    sum = n               *(a1 + an)   / 2;
            //int cur = (high - low + 1)*(low + high) / 2;
            int cur = (high + low) * (high - low + 1) / 2;
            //如果和==sum
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