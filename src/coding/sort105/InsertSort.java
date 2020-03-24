package coding.sort105;

public class InsertSort {
    public static void main(String[] args) {
        int[] s = {1, 9, 8, 5, 6, 44, 23, 25, 47, 9654};
        System.out.println("≈≈–Ú«∞");
        for (int i = 0; i < s.length - 1; i++) {
            System.out.print(s[i] + " ");

        }
        insertSort(s);
        System.out.println();
        System.out.println("≈≈–Ú∫Û");
        for (int i = 0; i < s.length - 1; i++) {
            System.out.print(s[i] + " ");

        }

    }

    private static void insertSort(int[] s) {
        // TODO Auto-generated method stub
        int temp;
        for (int i = 0; i < s.length; i++) {
            temp = s[i];
            int j = i;
            for (; j > 0 && temp < s[j - 1]; j--) {
                s[j] = s[j - 1];
            }
            s[j] = temp;
        }
    }
}
