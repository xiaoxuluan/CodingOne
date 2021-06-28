package coding.offer;

import java.util.ArrayList;

public class Dayinjuzhen {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (left <= right && top <= bottom) {
            //´òÓ¡ÉÏ²ã
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            //´òÓ¡ÓÒ²à
            for (int i = top + 1; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            //´òÓ¡µ×²¿
            if (top != bottom) {
                for (int i = right - 1; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            //´òÓ¡×ó²à
            if (left != right) {
                for (int i = bottom - 1; i > top; i--) {
                    list.add(matrix[i][left]);
                }
            }

            top++;
            left++;
            right--;
            bottom--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        Dayinjuzhen d = new Dayinjuzhen();
        ArrayList<Integer> list = d.printMatrix(numbers);
        System.out.println(list);
    }
}