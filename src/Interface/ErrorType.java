package Interface;

import Logic.Input;

import javax.swing.*;

 public class ErrorType extends Input {
   JOptionPane error;
    public void Error(){
        error.showMessageDialog(null,"Вами було введено число неправильного формату.");
    }
}
