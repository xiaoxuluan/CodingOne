package coding.offer;

public class CharaacterCompress {
	
	public static void main(String[] args) {
		encode("abcdaaaaa");
		encode("aaabbbcccghjkdddla");
		encode("abcabcabc");
	}

	private static void encode(String string) {
		// TODO Auto-generated method stub
		//��һ�� �ж��ַ����Ƿ�Ϊ��
		if(string==null||string.equals("")) {
			return ;
		}
		//��stringbuffer�����ظ������ַ�chuan����
		StringBuffer sb  = new StringBuffer();
		int count = 1;
		//�õ�һ��Ԫ����Ϊ��׼Ԫ��
		char element = string.charAt(0);
		//���б���
		for(int i = 1;i<string.length();i++) {
			
			if(string.charAt(i)==element) { //���Ԫ����ȣ�count++
				count++;
			}else { //����� ����׷��
				sb.append(element);
				sb.append(count==1? "":count);
				element=string.charAt(i);//element���¸�ֵ
				count=1;
			}
		}
		sb.append(element);
		sb.append(count==1?"":count);
		System.out.println(sb.toString());
	}
	

}
