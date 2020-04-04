package coding2.thread;

/**
 * @Author: luanyanxu
 * @Date: 2020/4/3 16:14
 * @Version 1.0
 */
public class C1 {

    public static void main(String[] args) {
        System.out.println(getDivision(10));
    }
    public static int getDivision(int n){
        try{
            n+=1;
            if(n/0 > 0){
                n+=10;
            } else {
                n-=10;
            }
            return n;
        }catch(Exception e){
            n++;
        }
        n++;
        return n++;
    }
}
