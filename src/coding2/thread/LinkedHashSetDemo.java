package coding2.thread;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/6 17:50
 * @Version 1.0
 */
public class LinkedHashSetDemo {

    public static void main(String[] args) {
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("luanyanxu");
        set1.add("henu");
        set1.add("cmcc");
        set1.add("jiangnanpigechang");

        System.out.println(set1.size());
        System.out.println(set1.isEmpty());
        System.out.println(set1.contains("henu"));

    }
}
