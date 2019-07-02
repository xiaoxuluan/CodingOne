package coding.offer;

public class CharaacterCompress {
	
	public static void main(String[] args) {
		encode("abcdaaaaa");
		encode("aaabbbcccghjkdddla");
		encode("abcabcabc");
	}

	private static void encode(String string) {
		// TODO Auto-generated method stub
		//第一步 判断字符串是否为空
		if(string==null||string.equals("")) {
			return ;
		}
		//用stringbuffer不会重复创建字符chuan对象
		StringBuffer sb  = new StringBuffer();
		int count = 1;
		//用第一个元素作为基准元素
		char element = string.charAt(0);
		//进行遍历
		for(int i = 1;i<string.length();i++) {
			
			if(string.charAt(i)==element) { //如果元素相等，count++
				count++;
			}else { //不相等 进行追加
				sb.append(element);
				sb.append(count==1? "":count);
				element=string.charAt(i);//element重新赋值
				count=1;
			}
		}
		sb.append(element);
		sb.append(count==1?"":count);
		System.out.println(sb.toString());
	}
	

}
