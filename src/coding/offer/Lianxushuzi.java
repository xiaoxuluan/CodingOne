package coding.offer;

import java.util.ArrayList;

public class Lianxushuzi {
	
	public ArrayList<ArrayList<Integer>> findxulie(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();

		int low = 1;
		int high = 2;
		while(high>low) {
		int cur = (low + high) * (high -low+1 )/2;
		if(cur==sum) {
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = low;i<=high;i++) {
				list.add(i);
			}
			result.add(list);
			low++;
		}else if(cur < sum) {
			high++;
		}else {
			low++;
		}
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		Lianxushuzi l = new Lianxushuzi();
		System.out.println(l.findxulie(100));
	}

}
