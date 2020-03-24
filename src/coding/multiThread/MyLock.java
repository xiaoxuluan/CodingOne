package coding.multiThread;

/**
 * @Author: alenlyx
 * @Date: 2019/10/13 11:59
 * @Version 1.0
 */
public class MyLock {

    public static void main(String[] args) {
        Integer a = 999;
        Integer b = 999;

        Integer c = 9;
        Integer d = 9;
        System.out.println(a==b);
        System.out.println(c==d);

        System.out.println(a.equals(b));


    }
}
