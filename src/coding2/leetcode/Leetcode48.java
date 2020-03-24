package coding2.leetcode;


/**
 * @author alenlyx
 */
public class Leetcode48 {

    /**
     * ֱ�Ӿ�����:
     *
     * ��ת��������,�ٰ����Խ��߽������ߵ���
     *
     * [                    [                  [
     *   [1,2,3],             [7,8,9],            [7,4,1],
     *   [4,5,6],    ---->    [4,5,6], ----->     [8,5,2],
     *   [7,8,9]              [1,2,3]             [9,6,3]
     * ]                    ]                  ]
     *ʱ�临�Ӷ� O��N^2)
     * �ռ临�Ӷ� O(1)
     */

    private void rotate(int[][] matrix){
        int n = matrix.length;

        //���·�ת
        for (int i = 0; i <n/2 ; i++) {
            for (int j = 0; j < n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        //�ԽǷ�ת
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
            }
        }
    }

    public static void main(String[] args) {
        int [] [] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

        new Leetcode48().rotate(matrix);

        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
