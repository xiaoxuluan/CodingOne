package coding.proxy.jdkproxy;

/**
 * @Author: alenlyx
 * @Date: 2019/10/20 3:04
 * @Version 1.0
 */
public class Client {

    /**
     * 1.声明一个接口
     * 2.为该接口创建实现类
     * 3.创建代理类实现java.lang.reflect.InvocationHandler接口
     * 4.客户端实现进行测试
     * -------------------------------------------
     * 1.jdk针对接口实现代理 不能针对类
     * 2.cglib通过继承方式实现代理  所以类或者方法不要声明为final形式的方式
     *
     * bean实现接口 spring使用jdk的动态代理
     * bean没有实现接口 spring使用cglib来实现代理
     * @param args
     */

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = new JdkDemo(new RealSubject()).getProxy();
        subject.say();
    }
}
