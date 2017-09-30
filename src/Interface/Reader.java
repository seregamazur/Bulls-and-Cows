package Interface;
import Logic.Input;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class Reader extends JFrame {
    eHandler handler = new eHandler();
    ErrorType er = new ErrorType();
    GiveUp stand = new GiveUp();
    NewGame game = new NewGame();
    public static JTextArea area;
    private JButton b1,b2,b3,b4;
    private JFormattedTextField t1;
    public static String guessStr;

     public Reader(String a) {
        super(a);
        String column_names[]= {"№","Число"};
        setLayout(null);

        t1 = new JFormattedTextField();
        //t = new TableModel
        b2 = new JButton("Ввід");
        b3 = new JButton("Здаюсь!");
        b1 = new JButton("Нова гра");
        b4 = new JButton("Вихід");
       area = new JTextArea();
        b2.setBounds(130, 12, 60, 20); //y - высота(чем больше тем ниже) x - ширина
        t1.setBounds(20, 10, 100, 25);
        b3.setBounds(200, 12, 100, 20);
        b1.setBounds(310, 12, 160, 20);
        b4.setBounds(480, 12, 100, 20);
        area.setBounds(25,90,270,350);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);area.setEnabled(true);area.setEditable(true);
        add(area);
        add(t1);
        add(b2);
        add(b3);
        add(b1);
        add(b4);
        b2.addActionListener(handler);
        b4.addActionListener(handler);
        b3.addActionListener(handler);
        b1.addActionListener(handler);
        PlainDocument doc = (PlainDocument) t1.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        }
       protected void text(){
         if(t1.getText().isEmpty()){er.Error1();}
         else{guessStr = t1.getText();}
        }
        protected void text1(){
            System.out.println(area.getText());
        }

     class eHandler extends  Input implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(b4)){
                dispose();
            }
            if(e.getSource().equals(b2)){
               text();
                Incompare();
                text1();
            }
            if(e.getSource().equals(b3)){
            stand.up();
            }
            if(e.getSource().equals(b1)){
                game.newgame();
            }
    }}
    class DigitFilter extends DocumentFilter {
        private static final String DIGITS = "\\d+";
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

            if (string.matches(DIGITS)) {
                super.insertString(fb, offset, string, attr);
            }
        }
        public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
            if (string.matches(DIGITS)) {
                super.replace(fb, offset, length, string, attrs);
            }
        }
    }

    }





