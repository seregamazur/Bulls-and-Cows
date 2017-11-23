package logics;

public class Move {
    public static void nextPermutation(int[] digits) {
        int i = digits.length - 2;
        while (i >= 0 && digits[i + 1] <= digits[i]) {
            i--;
        }
        if (i >= 0) {
            int j = digits.length - 1;
            while (j >= 0 && digits[j] <= digits[i]) {
                j--;
            }
            swap(digits, i, j);
        }
        reverse(digits, i + 1);
    }

    private static void reverse(int[] digits, int start) {
        int i = start, j = digits.length - 1;
        while (i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] digits, int i, int j) {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}