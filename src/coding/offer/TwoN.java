package coding.offer;

/**
 * @author luanyanxu
 * @version 1.0
 * @date 2019/7/19 15:45
 */
public class TwoN {

    public static void main(String[] args) {

        /*
          ͨ��Java���ж�һ�����Ƿ���2��n�η���

          ˼·��
          ������������������������һ�������� �� �� λ���㣬
          ���������Ϊ�����ʾ�����Ϊ2��n�η���
          ��������˵����������������ԡ�
          0 & 0 = 0
          1 & 0 = 0
          0 & 1 = 0
          1 & 1 = 1

          8 & 7 = 0
          7 & 6 = 6
          ����8��2��3�η�
          7 ���� 2 �� �η�
         */
        System.out.println(8 & 7);
        System.out.println(7 & 6);
    }
}
