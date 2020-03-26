package coding2.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/26 11:22
 * @Version 1.0
 */
public class Leetcode205 {

    public static void main(String[] args) {
        String s = "abb";
        String t = "egg";
        boolean result = isIsomerphicHelper(s,t)&&isIsomerphicHelper(t,s);
        System.out.println(result);
    }

    public static boolean isIsomerphicHelper(String s, String t){
        int n = s.length();
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(map.get(c1) !=c2){
                    return false;
                }
            }else {
                map.put(c1,c2);
            }

        }
        return true;
    }

    public static boolean func2(String s,String t){
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for (int i = 0; i < sc.length; i++) {
            if(!map1.containsKey(sc[i])){
                map1.put(sc[i],i);
            }

            if(!map2.containsKey(tc[i])){
                map2.put(tc[i],i);
            }

            if(map1.get(sc[i]).intValue() != map2.get(tc[i]).intValue()){
                return false;
            }

        }
        return true;
    }
}
