package coding2.l2;

/**
 * @Author: alenlyx
 * @Date: 2020/3/21 16:31
 * @Version 1.0
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton(){};

    public static synchronized Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        System.out.println(singleton);
    }
}
