package Interface;

import Logic.GenerateNumb;

import javax.swing.*;

public class GiveUp extends GenerateNumb{
    JOptionPane give;
    public void up(){
        give = new JOptionPane();
        give.showMessageDialog( null,"The right numb is:" + numbStr );
    }

}
