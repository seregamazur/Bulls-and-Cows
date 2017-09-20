package Interface;

import Logic.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Reader extends JFrame {;
    Input in = new Input();
    JTextArea textp ;
    JScrollPane pane;
    JButton b1,b2,b3,b4;
    JTextField t1;
    int guess;
    eHandler handler = new eHandler();
    public Reader(String s){
        super(s);
        setLayout(null);
        textp = new JTextArea();
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







        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(t1);
        add(b2);
        add(b3);
        add(b1);
        add(b4);
        add(pane);
        b2.addActionListener(handler);
        b4.addActionListener(handler);}

        public class eHandler implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == b4){
                    dispose();
                                   }
                if(e.getSource() == b2){
                    in.Incompare();
                }




    }}}



