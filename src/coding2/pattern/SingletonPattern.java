package coding2.pattern;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/7 16:08
 * @Version 1.0
 */
public class SingletonPattern {

    //懒汉式
    private static  SingletonPattern instance;

    private SingletonPattern(){};

    public static SingletonPattern getInstance(){

        if (instance == null){
            instance =  new SingletonPattern();
        }

        return instance;
    }

    //饿汉式 单例模式


}
