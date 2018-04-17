package model;

import java.io.Serializable;

public class InputGetter implements Serializable{
    private static final long serialVersionUID = 5405172041950251804L;
    private int inputNumb;
    private static int inputNumber;

    public static void setInputNumber(int inputNumber) {
        InputGetter.inputNumber = inputNumber;
    }


    public int getInputNumb() {
        return inputNumb;
    }

    public void setInputNumb(int inputNumb) {
        this.inputNumb = inputNumb;
    }


    public static int getInputNumber() {
        return inputNumber;
    }
}
