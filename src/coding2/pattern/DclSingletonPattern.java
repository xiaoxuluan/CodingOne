package coding2.pattern;

/**
 * @Author: alenlyx
 * @Date: 2019/9/7 16:15
 * @Version 1.0
 */
public class DclSingletonPattern {

    private static DclSingletonPattern dclSingletonPattern;

    private DclSingletonPattern(){};

    //ʹ��˫�ؼ��������  �ж϶����Ƿ�ʵ���� Ȼ���ڽ���ʵ����  ���ܸ� �̰߳�ȫ
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
