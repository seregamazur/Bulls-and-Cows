package Interface;
import Logic.Input;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class Reader extends JFrame {
    Input in = new Input();
    eHandler handler = new eHandler();
    GiveUp stand = new GiveUp();
    JTable table = new JTable();
    JScrollPane pane;
    JButton b1,b2,b3,b4;
    JTextField t1;
    public static String guessStr;



    public Reader(String a) {
        super(a);
        String column_names[]= {"№","Число"};
        setLayout(null);
        pane = new JScrollPane(table);
        t1 = new JTextField();
        b2 = new JButton("Ввід");
        b3 = new JButton("Здаюсь!");
        b1 = new JButton("Нова гра");
        b4 = new JButton("Вихід");
        b2.setBounds(130, 12, 60, 20); //y - высота(чем больше тем ниже) x - ширина
        t1.setBounds(20, 10, 100, 25);
        b3.setBounds(200, 12, 100, 20);
        b1.setBounds(310, 12, 160, 20);
        b4.setBounds(480, 12, 100, 20);
        table.setBounds(20, 140, 300, 300);
       DefaultTableModel table_model=new DefaultTableModel(column_names,999);
        table=new JTable(table_model);
        add(t1);
        add(b2);
        add(b3);
        add(b1);
        add(b4);
        add(new JScrollPane(table));
        b2.addActionListener(handler);
        b4.addActionListener(handler);
        b3.addActionListener(handler);
        }
        public void text(){
        guessStr = t1.getText();
        }


        public class eHandler implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == b4){
                    dispose();
                }
                if(e.getSource() == b2){
                   text();
                    in.Incompare();
                }
                if(e.getSource() == b3){
                stand.up();
                }





    }}}





