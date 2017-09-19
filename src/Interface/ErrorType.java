package Interface;

import javax.swing.*;
import java.awt.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class ErrorType extends JFrame{

          JPanel panel ;
        JOptionPane mess;
        JFrame error ;
    public void viewErr(){
        error = new JFrame();

        mess = new JOptionPane();
        panel = new JPanel();
        error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        error.setSize(300, 200);
        error.setResizable(false);
        error.setLocationRelativeTo(null);
        error.setVisible(true);
        mess.showMessageDialog(error,
                "Incorrect format of numb.Try again",
                "Input format error",
                JOptionPane.ERROR_MESSAGE);
    }
}
