package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2019/9/5 15:39
 * @Version 1.0
 */
public class Leetcode43 {
    /**
     * 大数相乘法
     */

    public String multiply(String num1,String num2){
        if(num1 == null || num2 == null){
            return null;
        }
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }

        int len = num1.length() + num2.length(),flag = 0;

        int [] data = new int[len];
        StringBuilder result = new StringBuilder();
        for (int i = num1.length()-1;i>=0;i--){
            for (int j = num2.length()-1;j>=0;j--){
                data[i+j+1]+= (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                if(data[i+j+1]>=10){
                    int tmp = data[i+j+1];
                    data[i+j+1]= tmp%10;
                    data[i+j]+= tmp/10;
                }
            }
        }
        int k = 0;
        for (;k<len;k++){
            if(data[k]!=0){
                break;
            }

        }

        while (k<len){
            result.append(data[k++]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        String s = new Leetcode43().multiply(num1,num2);
        System.out.println(s);
    }


}
