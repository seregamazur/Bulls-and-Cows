package Interface;

import Logic.GenerateNumb;

import javax.swing.*;
import java.awt.*;

public class GiveUp {
    GenerateNumb gen = new GenerateNumb();
    JOptionPane give;
    public void up(){
        give = new JOptionPane();
        give.showMessageDialog(give, "The right numb is:" + gen.guessStr );
    }

}
