package Interface;

import javax.swing.*;
import java.awt.*;

public class ErrorType extends JFrame {
    JOptionPane error;
    public void Error(){
        error.showMessageDialog(null,"Incorrect type input.Try again.");
    }
}
