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

        //�����������ֵ��ָ������
        OptionalTest optionalTest = new OptionalTest();
        Integer value1 = 20;
        Integer value2 = new Integer(10);

        Integer value3 = null;

        //Optional.OfNullable - ������Ϊ null ����
        Optional<Integer> a = Optional.ofNullable(value1);

        //Optional.of -������ݵĲ�����null,�׳��쳣 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(optionalTest.sum(a, b));

        List<Integer> list = new ArrayList<>();

        OptionalTest.checkListIsNull(list);


    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("��һ������ֵ����:" + a.isPresent());
        System.out.println("�ڶ�������ֵ����:" + b.isPresent());

        //Optional.orElse -���ֵ���ڣ������������򷵻�Ĭ��ֵ
        Integer value1 = a.orElse(new Integer(0));
        //Integer value1 = a.get();

        //Optional.get() -��ȡֵ��ֵ��Ҫ����
        Integer value2 = b.get();
        return value1 + value2;
    }

    public static void checkListIsNull(List<Integer> list) {
        Optional<List<Integer>> result = Optional.ofNullable(list);
        System.out.println(result);

    }
}
