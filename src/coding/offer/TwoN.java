package coding.offer;

/**
 * @author luanyanxu
 * @version 1.0
 * @date 2019/7/19 15:45
 */
public class TwoN {

    public static void main(String[] args) {

        /*
          通过Java，判断一个数是否是2的n次方？

          思路：
          所给出的数与所给出的数减一的数进行 与 的 位运算，
          如果运算结果为零则表示这个数为2的n次方，
          而这道题据说考验的是数据敏感性。
          0 & 0 = 0
          1 & 0 = 0
          0 & 1 = 0
          1 & 1 = 1

          8 & 7 = 0
          7 & 6 = 6
          所以8是2的3次方
          7 不是 2 的 次方
         */
        System.out.println(8 & 7);
        System.out.println(7 & 6);
    }
}
