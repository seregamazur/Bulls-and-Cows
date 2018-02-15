package utils;

public class CheckerNumber {

    public static boolean hasNoDupes(int num) {
        for (boolean[] digs = new boolean[10]; num > 0; num /= 10) {
            if (digs[num % 10]) {
                return false;
            }
            digs[num % 10] = true;
        }
        return true;
    }

}
