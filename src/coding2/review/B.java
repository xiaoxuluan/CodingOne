package coding2.review;

/**
 * @Author: alenlyx
 * @Date: 2019/10/15 17:37
 * @Version 1.0
 */

/**
 * ����ִ��˳��
 * ���ྲ̬�����
 * ���ྲ̬�����
 * ������ͨ�����
 * ������ͨ����
 * ������ͨ�����
 * ������ͨ����
 */
class  A{
    public A(){
        System.out.println("class A");
    }
    {
        System.out.println("I am class A");
    }

    static {
        System.out.println("class A static");
    }
}
public class B extends A{
    public B(){
        System.out.println("class B");
    }
    {
        System.out.println("i am class B");
    }
    static {
        System.out.println("class B static");
    }

    public static void main(String[] args) {
        new B();
    }
}
