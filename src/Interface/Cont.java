package Interface;
import Logic.GenerateNumb;

import javax.swing.JFrame;

public class Cont {
    public static void main(String[] args) {
        GenerateNumb gen = new GenerateNumb();
        gen.go();
        Reader r = new Reader("Бики та корови.Гра");
        r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r.setSize(600, 500);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
        r.setVisible(true);}
                           }

