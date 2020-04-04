package coding2.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/26 13:14
 * @Version 1.0
 */
public class Leetcode202 {


    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1){
            n = change(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public int change(int n){
        int sum = 0;
        int num;
        while (n != 0){
            num = n % 10;
            n /= 10;
            sum += num * num;
        }
        return sum;
    }

    public boolean isHappy2(int n){
        int sum = n;
        StringBuilder sb = new StringBuilder();
        Set<Integer> set  = new HashSet<>();
        while (!set.contains(sum)){
            set.add(sum);
            sb.append(sum);
            sum=0;
            for (int i = 0; i < sb.length(); i++) {
                sum += Math.pow(sb.charAt(i)-'0',2);
            }

            if(sum == 1 ){
                return true;
            }
            sb.setLength(0);
        }
        return false;
    }
}
