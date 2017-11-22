package logics;

import java.util.Arrays;

public class Move {
    final private GenerateNumb gen = new GenerateNumb();
    final private Condition cond = new Condition();
    private String finalStr;
    public String getFinalStr() {
        return finalStr;
    }

    public void setBullcount(int bullcount) {
        this.bullcount = bullcount;
    }

    public void setCowcount(int cowcount) {
        this.cowcount = cowcount;
    }

    private int bullcount;
    private int cowcount;
    public int getCowcount() {
        return cowcount;
    }
    public int getBullcount() {
        return bullcount;
    }

    public void setFinalStr(String finalStr) {
        this.finalStr = finalStr;
    }
    public static void swap(final int[] digits){
        final int temp = digits[0];
        digits[0] = digits[1];
        digits[1] = temp;
    }


    public void tryTo(GenerateNumb go){
        cowcount = 0;
        bullcount = 0;
    int[]digits = go.getNumbStr().chars().map(c -> c-='0').toArray();
    swap(digits);
        StringBuilder builder = new StringBuilder();
        for (int i : digits) {
            builder.append(i);
        }
        setFinalStr(builder.toString());
        for (int i = 0; i < cond.getSize(); i++) {
            if (cond.getGuessStr().charAt(i) == Arrays.toString(digits).charAt(i)) {
                bullcount++;
            } else if (cond.getGuessStr().contains(Arrays.toString(digits).charAt(i) + "")) {
                cowcount++;
            }
        }}
}







