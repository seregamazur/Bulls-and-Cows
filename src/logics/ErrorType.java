package logics;


import javax.swing.*;

public class ErrorType {
    private final JOptionPane error = new JOptionPane();

    public void incType(Condition cond) {
        error.showMessageDialog(null, "Ви задали число неправильно формату.\nКількість цифр в числі правильного формату: " + cond.getSize());
    }

    public void emptyType() {
        error.showMessageDialog(null, "Вами не було введено число.");
    }

    public void sameType() {
        error.showMessageDialog(null, "Ви вже вводили дане число");
    }

    public void giveUp(GenerateNumb go) {
        error.showMessageDialog(null, "Ви програли!\nПравильним числом було:" + go.getNumbStr());
    }
}
