package logics;


import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

import static javax.swing.JOptionPane.showMessageDialog;

public class Condition {
    private String guessStr;
    private int bullcount;
    private int cowcount;
    private int guesses;
    private int size;
    private int luckyCount = 0;
    private boolean guessed = false;

    public int getSize() {
        return size;
    }

    public Set<Integer> getExceptedNumb() {
        return exceptedNumb;
    }

    private Set<Integer> exceptedNumb = new HashSet<>();

    public void setSize(int size) {
        this.size = size;
    }

    public int getLuckyCount() {
        return luckyCount;
    }


    public void setLuckyCount(int luckyCount) {
        this.luckyCount = luckyCount;
    }

    public String getGuessStr() {
        return guessStr;
    }

    public void setGuessStr(String guessStr) {
        this.guessStr = guessStr;
    }

    public void setBullcount(int bullcount) {
        this.bullcount = bullcount;
    }

    public int getCowcount() {
        return cowcount;
    }

    public void setCowcount(int cowcount) {
        this.cowcount = cowcount;
    }

    public int getBullcount() {
        return bullcount;
    }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }


    public void cond(GenerateNumb go) {
        if (exceptedNumb.contains(guessStr)) guesses--;
        try {
            guesses++;
            guessed = false;
            for (int i = 0; i < size; i++) {
                if (guessStr.charAt(i) == go.getNumbStr().charAt(i)) {
                    bullcount++;
                } else if (go.getNumbStr().contains(getGuessStr().charAt(i) + "")) {
                    cowcount++;
                }
            }
            exceptedNumb.add(Integer.parseInt(guessStr));

            if (bullcount == size) {
                guessed = true;
            }
            if (guessed) {
                exceptedNumb.clear();
                showMessageDialog(null, "Ви виграли за " + getGuesses() + " спроб!");
            }

        } catch (InputMismatchException | NumberFormatException es) {
        }
    }

    public void comp(WithCompGen genc) {
        try {
            guesses++;
            guessed = false;
            for (int i = 0; i < size; i++) {
                if (guessStr.charAt(i) == genc.getCompNumb().charAt(i)) {
                    bullcount++;
                } else if (genc.getCompNumb().contains(guessStr.charAt(i) + "")) {
                    cowcount++;
                }
            }
            exceptedNumb.add(Integer.parseInt(genc.getCompNumb()));
            setLuckyCount(bullcount + cowcount);
            if (luckyCount == 0) {
                guesses--;
                exceptedNumb.add(Integer.parseInt(genc.getCompNumb()));
            }

            if (bullcount == size) {
                guessed = true;
            }

            if (guessed) {
                genc.getArrayList().clear();
                exceptedNumb.clear();
                showMessageDialog(null, "Комп'ютер відгадав ваше число за " + guesses + " спроб!");


            }
        } catch (InputMismatchException | NumberFormatException es) {
        }
    }

}

