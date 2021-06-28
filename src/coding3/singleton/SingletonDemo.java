package coding3.singleton;

/**
 * @Author: luanyanxu
 * @Date: 2021/4/6 20:22
 * @Version 1.0
 */
public class SingletonDemo {

    private static SingletonDemo singletonDemo;

    private SingletonDemo(){}

    public static SingletonDemo getInstance(){
        if(singletonDemo == null){
            singletonDemo = new SingletonDemo();
        }
        return singletonDemo;
    }
}
