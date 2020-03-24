package coding.proxy.jdkproxy;

/**
 * @Author: alenlyx
 * @Date: 2019/10/20 3:04
 * @Version 1.0
 */
public class Client {

    /**
     * 1.����һ���ӿ�
     * 2.Ϊ�ýӿڴ���ʵ����
     * 3.����������ʵ��java.lang.reflect.InvocationHandler�ӿ�
     * 4.�ͻ���ʵ�ֽ��в���
     * -------------------------------------------
     * 1.jdk��Խӿ�ʵ�ִ��� ���������
     * 2.cglibͨ���̳з�ʽʵ�ִ���  ��������߷�����Ҫ����Ϊfinal��ʽ�ķ�ʽ
     *
     * beanʵ�ֽӿ� springʹ��jdk�Ķ�̬����
     * beanû��ʵ�ֽӿ� springʹ��cglib��ʵ�ִ���
     * @param args
     */

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = new JdkDemo(new RealSubject()).getProxy();
        subject.say();
    }
}
