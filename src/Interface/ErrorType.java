package Interface;

import javax.swing.*;
import java.awt.*;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class ErrorType extends JFrame{
          JPanel panel ;

        JFrame error ;
    public void viewErr(){
        error = new JFrame();
        panel = new JPanel();
        error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(300, 200);
        error.setResizable(false);
        error.setLocationRelativeTo(null);
        panel.setVisible(true);
        JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Failure");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

}
