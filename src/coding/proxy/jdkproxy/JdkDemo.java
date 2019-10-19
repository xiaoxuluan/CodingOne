package coding.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: luanyanxu
 * @Date: 2019/10/20 2:59
 * @Version 1.0
 */
public class JdkDemo implements InvocationHandler {
    private Object target;

    public JdkDemo(Object target){
        this.target = target;
    }

    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hello world before");
        Object result = method.invoke(target,args);
        System.out.println("hello world after");
        return result;

    }
}
