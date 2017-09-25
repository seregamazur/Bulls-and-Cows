package Interface;
import Logic.Input;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Reader extends JFrame {
    eHandler handler = new eHandler();
    ErrorType er = new ErrorType();
    GiveUp stand = new GiveUp();
    NewGame game = new NewGame();
    private JTable table ;
    private JButton b1,b2,b3,b4;
    private JTextField t1;
    public static String guessStr;



     public Reader(String a) {
        super(a);
        String column_names[]= {"№","Число"};
        setLayout(null);
        t1 = new JTextField();
        b2 = new JButton("Ввід");
        b3 = new JButton("Здаюсь!");
        b1 = new JButton("Нова гра");
        b4 = new JButton("Вихід");
        table = new JTable();
        b2.setBounds(130, 12, 60, 20); //y - высота(чем больше тем ниже) x - ширина
        t1.setBounds(20, 10, 100, 25);
        b3.setBounds(200, 12, 100, 20);
        b1.setBounds(310, 12, 160, 20);
        b4.setBounds(480, 12, 100, 20);
        table.setBounds(20, 140, 300, 300);
        add(t1);
        add(b2);
        add(b3);
        add(b1);
        add(b4);
        b2.addActionListener(handler);
        b4.addActionListener(handler);
        b3.addActionListener(handler);
        b1.addActionListener(handler);
        }
       protected void text(){
         if(t1.getText().isEmpty()){er.Error1();}
        guessStr = t1.getText();
        }


     class eHandler extends  Input implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(b4)){
                dispose();
            }
            if(e.getSource().equals(b2)){
               text();
                Incompare();
            }
            if(e.getSource().equals(b3)){
            stand.up();
            }
            if(e.getSource().equals(b1)){
                game.newgame();
            }






    }}

    }





