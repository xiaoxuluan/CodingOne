package coding.offer;

import java.util.HashMap;

public class Dayuyiban {
	public static void panduan(int [] s) {
		//处理边界值范围
		if(s.length==1) {
			System.out.println(s[0]);
		}
		HashMap <Integer,Integer> map = new HashMap<>();
		for(int i=0;i<s.length;i++) {
			if(map.containsKey(s[i])) {
				map.put(s[i], map.get(s[i])+1);
			}else {
				map.put(s[i],1);
			}
		}
		for (Integer key : map.keySet()) {
			if(map.get(key)>=(s.length/2))
			    System.out.println("key= "+ key + " and value= " + map.get(key));
			 }
	}
	
	public static void main(String[] args) {
		int [] s = {1,2,3,4,5,5,5,5};
		panduan(s);
	}

}
