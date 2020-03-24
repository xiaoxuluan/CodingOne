package coding2.pattern;

/**
 * @Author: alenlyx
 * @Date: 2019/9/7 16:15
 * @Version 1.0
 */
public class DclSingletonPattern {

    private static DclSingletonPattern dclSingletonPattern;

    private DclSingletonPattern(){};

    //使用双重检查锁机制  判断对象是否被实例化 然后在进行实例化  性能高 线程安全
    public static DclSingletonPattern getDclSingletonPattern(){
        if (dclSingletonPattern == null){
            synchronized (DclSingletonPattern.class){
                if (dclSingletonPattern == null){
                    dclSingletonPattern = new DclSingletonPattern();
                }
            }
        }
        return dclSingletonPattern;
    }
}
