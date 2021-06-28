package coding3.singleton;

/**
 * @Author: luanyanxu
 * @Date: 2021/4/6 20:18
 * @Version 1.0
 */
public class DclSingleton {

    private static DclSingleton dclSingleton;

    private DclSingleton(){};

    public static DclSingleton getDclSingleton(){
        if(dclSingleton == null){
            synchronized (DclSingleton.class){
                if(dclSingleton == null){
                    dclSingleton = new DclSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
