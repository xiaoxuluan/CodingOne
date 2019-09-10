package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/10 13:00
 * @Version 1.0
 */
public class Leetcode62 {

    /**
     * 我们用 R 表示向右，D 表示向下，然后把所有路线写出来，就会发现神奇的事情了。
     *
     * R R R D D
     *
     * R R D D R
     *
     * R D R D R
     *
     * ……
     *
     * 从左上角，到右下角，总会是 3 个 R，2 个 D，只是出现的顺序不一样。所以求解法，本质上是求了组合数，N = m + n - 2，也就是总共走的步数。 k = m - 1，也就是向下的步数，D 的个数。所以总共的解就是 C^k_n = n!/(k!(n-k)!) = (n*(n-1)*(n-2)*...(n-k+1))/k!C
     * n
     * k
     * ?
     *  =n!/(k!(n?k)!)=(n?(n?1)?(n?2)?...(n?k+1))/k!。
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
