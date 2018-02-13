package java.utils;


import javax.swing.*;

public class ErrorType {
    public static final JOptionPane error = new JOptionPane();

    public static void incType(GeneratorNumber gen) {
        error.showMessageDialog(null, "Ви задали число неправильно формату.\nКількість цифр в числі правильного формату: " + gen.getDigits());
    }

    public static void emptyType() {
        error.showMessageDialog(null, "Вами не було введено число.");
    }

    public static void sameType() {
        error.showMessageDialog(null, "Ви вже вводили дане число");
    }

    public static void giveUp(GeneratorNumber go) {
        error.showMessageDialog(null, "Ви програли!\nПравильним числом було:" + go.getGeneratedNumber());
    }
}
