package coding.proxy.jdkproxy;

/**
 * @Author: alenlyx
 * @Date: 2019/10/20 2:59
 * @Version 1.0
 */
public class RealSubject implements Subject {
    @Override
    public void say() {
        System.out.println("hello world");
    }
}
