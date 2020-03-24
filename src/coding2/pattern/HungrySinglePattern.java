package coding2.pattern;

/**
 * @Author: alenlyx
 * @Date: 2019/9/7 16:12
 * @Version 1.0
 */
public class HungrySinglePattern {

    private static HungrySinglePattern instance = new HungrySinglePattern();
    private HungrySinglePattern(){}

    public static HungrySinglePattern getInstance(){
        return instance;
    }
}
