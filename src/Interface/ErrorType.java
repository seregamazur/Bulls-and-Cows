package Interface;

import Logic.Input;

import javax.swing.*;

 public class ErrorType extends Input {
   JOptionPane error;
    public void Error(){
        error.showMessageDialog(null,"Вами було введено число неправильного формату.");
    }
    public void Error1(){error.showMessageDialog(null,"Вами не було введено число.");}
}
