package coding2.java8fornew;

import java.util.Optional;
import java.util.*;

/**
 * @Author: alenlyx
 * @Date: 2020/3/14 23:20
 * @Version 1.0
 */
public class OptionalTest {

    public static void main(String[] args) {

        //用来解决返回值空指针问题
        OptionalTest optionalTest = new OptionalTest();
        Integer value1 = 20;
        Integer value2 = new Integer(10);

        Integer value3 = null;

        //Optional.OfNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of -如果传递的参数是null,抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(optionalTest.sum(a, b));

        List<Integer> list = new ArrayList<>();

        OptionalTest.checkListIsNull(list);


    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("第一个参数值存在:" + a.isPresent());
        System.out.println("第二个参数值存在:" + b.isPresent());

        //Optional.orElse -如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));
        //Integer value1 = a.get();

        //Optional.get() -获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    public static void checkListIsNull(List<Integer> list) {
        Optional<List<Integer>> result = Optional.ofNullable(list);
        System.out.println(result);

    }
}
