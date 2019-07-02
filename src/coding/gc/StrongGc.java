package coding.gc;

public class StrongGc {
	public static void main(String[]args){
        Object obj=new Object();//强引用，默认
        Object ref=obj;//引用传递
        obj=null;//断开连接
        System.gc();
        System.out.println(ref.toString());
    }
}
