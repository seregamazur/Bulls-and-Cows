package view;

import logics.GenerateNumb;

import javax.swing.*;

 public class ErrorType {
    JOptionPane error = new JOptionPane();
     public void Error(){
        error.showMessageDialog(null,"Вами було введено число неправильного формату.");
    }
    public void Error1(){error.showMessageDialog(null,"Вами не було введено число.");}
    public void GiveUp(GenerateNumb go){error.showMessageDialog( null,"The right numb is:" +  go.getNumbStr() );}
}
