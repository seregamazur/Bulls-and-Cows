
import Interface.Reader;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;

public class Cont {
    public static void main(String[] args) {
        Reader r = new Reader("Бики та корови.Гра");
        r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r.setSize(600, 500);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);}
                           }

