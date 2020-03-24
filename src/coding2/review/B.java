package coding2.review;

/**
 * @Author: alenlyx
 * @Date: 2019/10/15 17:37
 * @Version 1.0
 */

/**
 * 代码执行顺序
 * 父类静态代码块
 * 子类静态代码块
 * 父类普通代码块
 * 父类普通方法
 * 子类普通代码块
 * 子类普通方法
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
