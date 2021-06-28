package coding3.singleton;

/**
 * @Author: luanyanxu
 * @Date: 2021/4/6 20:21
 * @Version 1.0
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getHungrySingleton(){
        return hungrySingleton;
    }
}
