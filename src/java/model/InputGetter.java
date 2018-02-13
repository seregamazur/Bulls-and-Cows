package java.model;

public class InputGetter {
    public static void setInputNumber(int inputNumber) {
        InputGetter.inputNumber = inputNumber;
    }

    private static int inputNumber;

    public int getInputNumb() {
        return inputNumb;
    }

    public void setInputNumb(int inputNumb) {
        this.inputNumb = inputNumb;
    }

    private int inputNumb;

    public static int getInputNumber() {
        return inputNumber;
    }
}
