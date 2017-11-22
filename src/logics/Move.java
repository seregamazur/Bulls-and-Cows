//package logics;
//
//import java.util.Arrays;
//
//public class Move {
//    final private Condition cond = new Condition();
//    private String finalStr;
//    public String getFinalStr() {
//        return finalStr;
//    }
//
//    public void setBullcount(int bullcount) {
//        this.bullcount = bullcount;
//    }
//
//    public void setCowcount(int cowcount) {
//        this.cowcount = cowcount;
//    }
//
//    private int bullcount;
//    private int cowcount;
//    public int getCowcount() {
//        return cowcount;
//    }
//    public int getBullcount() {
//        return bullcount;
//    }
//
//    public void setFinalStr(String finalStr) {
//        this.finalStr = finalStr;
//    }
//
//    public void nextPermutation(int[] digits) {
//        int i = digits.length - 2;
//        while (i >= 0 && digits[i + 1] <= digits[i]) {
//            i--;
//        }
//        if (i >= 0) {
//            int j = digits.length - 1;
//            while (j >= 0 && digits[j] <= digits[i]) {
//                j--;
//            }
//            swap(digits, i, j);
//        }
//        reverse(digits, i + 1);
//    }
//
//    private void reverse(int[] digits, int start) {
//        int i = start, j = digits.length - 1;
//        while (i < j) {
//            swap(digits, i, j);
//            i++;
//            j--;
//        }
//    }
//
//    private void swap(int[] digits, int i, int j) {
//        int temp = digits[i];
//        digits[i] = digits[j];
//        digits[j] = temp;
//    }
//
//
//
//    public void tryTo(GenerateNumb go){
//        cowcount = 0;
//        bullcount = 0;
//        cond.setGuesses(cond.getGuesses()+1);
//    int[]digits = .chars().map(c -> c-='0').toArray();
//    nextPermutation(digits);
//        StringBuilder builder = new StringBuilder();
//        for (int i : digits) {
//            builder.append(i);
//        }
//        setFinalStr(builder.toString());
//        for (int i = 0; i < cond.getSize(); i++) {
//            if (cond.getGuessStr().charAt(i) == Arrays.toString(digits).charAt(i)) {
//                bullcount++;
//            } else if (cond.getGuessStr().contains(Arrays.toString(digits).charAt(i) + "")) {
//                cowcount++;
//            }
//        }}
//}