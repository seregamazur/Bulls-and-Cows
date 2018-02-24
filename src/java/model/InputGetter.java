package model;

public class InputGetter {
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
