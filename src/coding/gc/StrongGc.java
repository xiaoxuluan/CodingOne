package coding.gc;

public class StrongGc {
	public static void main(String[]args){
        Object obj=new Object();//ǿ���ã�Ĭ��
        Object ref=obj;//���ô���
        obj=null;//�Ͽ�����
        System.gc();
        System.out.println(ref.toString());
    }
}
