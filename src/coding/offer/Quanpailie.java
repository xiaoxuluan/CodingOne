package coding.offer;

public class Quanpailie {
	public static void quanpailie(char [] s,int start,int end) {
		if(end<=1) {
			return ;
		}
		if(start==end) {
			System.out.println(s);
		}else {
			for(int i=start;i<=end;i++) {
				swap(s,i,start);
				quanpailie(s,start+1,end);
			}
		}
	}

	private static void swap(char[] s, int i, int j) {
		// TODO Auto-generated method stub
		char tmp = s[i];
		
		s[i]=s[j];
		s[j]=tmp;
	}
	
	public static void main(String[] args) {
		String m= "abc";
		char [] s = m.toCharArray();
		quanpailie(s,0,2);
	}

}
