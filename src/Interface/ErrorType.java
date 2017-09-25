package Interface;

import javax.swing.*;

public class ErrorType extends JFrame {
    JOptionPane error;
    public void Error(){
        error.showMessageDialog(null,"Вами було введено число неправильного формату.");
    }
}
