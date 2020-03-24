package coding2.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: alenlyx
 * @Date: 2019/10/14 1:03
 * @Version 1.0
 */
public class Leetcode350 {

    public static void main(String[] args) {

        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                map.put(nums1[i],1);
            }
        }

        for (int i = 0; i <nums2.length ; i++) {
            if(map.containsKey(nums2[i])){
                map.put(nums2[i],map.get(nums2[i])-1);
                if (map.get(nums2[i])==0){
                    map.remove(nums2[i]);
                }
                list.add(nums2[i]);
            }
        }

        int [] result = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        System.out.println(list);


    }
}
