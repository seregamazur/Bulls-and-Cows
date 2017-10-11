package Logic;

import Interface.ErrorType;

import java.util.InputMismatchException;

import static javax.swing.JOptionPane.showMessageDialog;

public class Condition {
    final ErrorType er = new ErrorType();
    final GenerateNumb gen = new GenerateNumb();
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

    private String guessStr;
    private int bullcount;
    private int cowcount;
    private int guesses;

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }

    private boolean guessed = false;
    public void cond(GenerateNumb go){
        try{
            int  guess = Integer.parseInt(guessStr);
            if(gen.hasDupes(guess) || guess < 1000 ) { er.Error();}
            else {guesses++;
                guessed = false;
                for(int i= 0;i < 4;i++){
                    if(guessStr.charAt(i) == go.getNumbStr().charAt(i)){
                        bullcount++;
                    }else if(go.getNumbStr().contains(getGuessStr().charAt(i)+"")){
                        cowcount++;
                    }
                }
                if(bullcount == 4){
                    guessed = true;
                }if(guessed == true){
                    showMessageDialog(null,"Ви виграли за " + getGuesses() +" спроб!");
                }}
            }catch(InputMismatchException | NumberFormatException es) {}
    }
}

