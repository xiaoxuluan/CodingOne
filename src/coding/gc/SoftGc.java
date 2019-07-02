package coding.gc;

import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;

public class SoftGc {
	public static void main(String[]args){
        /*Object obj=new Object();
        SoftReference<Object> ref=new SoftReference<Object>(obj);//软引用
        obj=null;//断开连接
        System.gc();
        System.out.println(ref.get());*/
		String s1 = "123456";
		String s2 = "123456";
		String s3 = s2;
		System.out.println(s1.equals(s2));
		System.out.println(s1==s3);
		System.out.println(s2.equals(s3));
		
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(1);
		s.add(2);
		
		System.out.println(5/0);
		
    }

}
