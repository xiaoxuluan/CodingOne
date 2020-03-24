package coding.dp;

import java.util.Scanner;

/**
 * @author alenlyx
 */
public class MemorySearch {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<25; i++) {
            for(int j=0; j<25; j++) {
                for(int k=0; k<25; k++) {
                    ww[i][j][k] = 0;
                }
            }
        }
        while(true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if(a == -1 && b == -1 && c == -1) {
                break;
            }else {
                System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
            }
        }
        scanner.close();
    }

    private static int[][][] ww= new int[25][25][25];

    public static int w(long a, long b, long c) {

        if(a<=0 || b<=0 || c<=0) {
            return 1;
        }else if(a>20 || b>20 || c>20){
            return w(20, 20, 20);
        }else {
            if(ww[(int) a][(int) b][(int) c] == 0) {
                if(a < b && b < c)
                {
                    ww[(int) a][(int) b][(int) c] =  w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
                }
                else
                {
                    ww[(int) a][(int) b][(int) c] =  w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
                }
                return ww[(int) a][(int) b][(int) c];
            }else {
                return ww[(int) a][(int) b][(int) c];
            }
        }

    }
}
