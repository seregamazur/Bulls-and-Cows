package utils;


import javax.swing.*;

public class ErrorType {
    private ErrorType() {
        throw new IllegalStateException("Utility class");
    }

    public static void incType(GeneratorNumber gen) {
        JOptionPane.showMessageDialog(null, "Ви задали число неправильно формату.\nКількість цифр в числі правильного формату: " + gen.getDigits());
    }

    public static void emptyType() {
        JOptionPane.showMessageDialog(null, "Вами не було введено число.");
    }

    public static void sameType() {
        JOptionPane.showMessageDialog(null, "Ви вже вводили дане число");
    }

    public static void giveUp(GeneratorNumber go) {
        JOptionPane.showMessageDialog(null, "Ви програли!\nПравильним числом було:" + go.getGeneratedNumber());
    }
}
