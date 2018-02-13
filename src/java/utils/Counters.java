package java.utils;

public class Counters {

    public static int[] getCowsAndBullsFromNumber(int number, int inputNumber) {
        final String num = number + "";
        final String inputNum = inputNumber + "";
        int cowCount = 0;
        int bullCount = 0;

        for (int i = 0; i < num.length(); i++) {
            if (inputNum.charAt(i) == num.charAt(i)) {
                bullCount++;
            } else if (num.contains(inputNum.charAt(i) + "")) {
                cowCount++;
            }
        }

        return new int[]{bullCount, cowCount};
    }
}
