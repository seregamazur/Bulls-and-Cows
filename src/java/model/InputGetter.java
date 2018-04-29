package model;

import java.io.Serializable;

public class InputGetter implements Serializable{
    private static final long serialVersionUID = 5405172041950251804L;
    private static int inputNumb;
    private static int inputNumber;

    public static void setInputNumber(int inputNumber) {
        InputGetter.inputNumber = inputNumber;
    }


    public static int getInputNumb() {
        return inputNumb;
    }

    public static void setInputNumb(int inputNumb) {
        InputGetter.inputNumb = inputNumb;
    }


    public static int getInputNumber() {
        return inputNumber;
    }
}
