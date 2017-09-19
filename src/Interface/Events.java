package Interface;

import Interface.Reader;
import Logic.Input;
import Logic.MainCond;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events implements ActionListener {
    Input comp = new Input();
MainCond result = new MainCond();
Reader r = new Reader(super.toString());
public void actionPerformed(ActionEvent e) {
if(e.getSource() == r.b2);{
    comp.Incompare();

}
}
}
