package Interface;

import javax.swing.*;
import java.awt.*;
import javax.swing.ScrollPaneConstants;

public class Reader extends JFrame {;
    JTextPane textp ;
    JScrollPane pane;
    JButton b1,b2,b3,b4;
    JTextField t1;
    public Reader(String s){
        super(s);
        setLayout(null);
        textp = new JTextPane();
        pane = new JScrollPane(textp);
        t1 = new JTextField();
        b2 = new JButton("Ввід");
        b3 = new JButton("Здаюсь!");
        b1 = new JButton("Нова гра");
        b4 = new JButton("Вихід");
        b2.setBounds(130,12,60,20); //y - высота(чем больше тем ниже) x - ширина
        t1.setBounds(20,10,100,25);
        b3.setBounds(200,12,100,20);
        b1.setBounds(310,12,160,20);
        b4.setBounds(480,12,100,20);
        textp.setBounds(30,120,250,300);

        pane.setBounds(50,120,15,300);

        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(t1);
        add(b2);
        add(b3);
        add(b1);
        add(b4);
        add(textp);
        add(pane);



    }


}
