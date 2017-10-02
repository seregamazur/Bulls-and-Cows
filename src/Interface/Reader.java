package Interface;
import Logic.GenerateNumb;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.swing.*;


import javax.imageio.ImageIO;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import static javax.swing.JOptionPane.showMessageDialog;


public class Reader extends javax.swing.JFrame {
    public static String  guessStr ;

    public Reader() {
        initComponents();
    }

   public void initComponents() {
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Бики та корови");
        setResizable(false);
       try {
           setIconImage(ImageIO.read(new File("res/bicho1.png")));
       }
       catch (IOException exc) {
           exc.printStackTrace();
       }

       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        sizeWidth = 600;
       sizeHeight = 500;
        locationX = (screenSize.width - sizeWidth) / 2;
       locationY = (screenSize.height - sizeHeight) / 2;
       setBounds(locationX, locationY, sizeWidth, sizeHeight);
       setVisible(true);

        jButton1.setText("Ввід");
       jButton1.addActionListener((ActionListener) new ActionListener() {
           public void actionPerformed(ActionEvent evt) {
               jButton1ActionPerformed(evt);
           }
       });
        jButton1.setToolTipText("Якщо впевнені");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14));
       PlainDocument doc = (PlainDocument) jTextField1.getDocument();
       doc.setDocumentFilter(new DigitFilter());



        jButton2.setText("Здаюсь");
        jButton2.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Нова гра");
        jButton3.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Вихід");
        jButton4.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });



       {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

           String headers[] = { "Cпроба", "Число","","" };
           final Object rows[][] = {};
           model=new DefaultTableModel(rows,headers){
               public boolean isCellEditable(int row, int headers) {
                   return false;
               }
           };
           JTable jTable1 = new JTable(model);
            Icon redIcon = new ImageIcon("res/bichochok.png");
            Icon blueIcon = new ImageIcon("res/korovka.png");

            Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");

            JLabel blueLabel = new JLabel(headers[2], blueIcon, JLabel.CENTER);
    blueLabel.setBorder(headerBorder);
            JLabel redLabel = new JLabel(headers[3], redIcon, JLabel.CENTER);
    redLabel.setBorder(headerBorder);

            TableCellRenderer renderer = new JComponentTableCellRenderer();

            TableColumnModel columnModel = jTable1.getColumnModel();

            TableColumn column0 = columnModel.getColumn(2);
            TableColumn column1 = columnModel.getColumn(3);

    column0.setHeaderRenderer(renderer);
    column0.setHeaderValue(blueLabel);

    column1.setHeaderRenderer(renderer);
    column1.setHeaderValue(redLabel);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }}

    private void jButton4ActionPerformed(java.awt.event.ActionEvent e) {

        dispose();

    }  private void jButton3ActionPerformed(java.awt.event.ActionEvent e) {
        NewGame game = new NewGame();

        game.newgame();

    }  private void jButton2ActionPerformed(java.awt.event.ActionEvent e) {


        stand.up();

    }  public void jButton1ActionPerformed(java.awt.event.ActionEvent e) {

            if(jTextField1.getText().isEmpty()){er.Error1();}
            else{
                guessStr = jTextField1.getText();
                guessStr.trim();
                try{
                    int  guess = Integer.parseInt(guessStr);
                    if(gen.hasDupes(guess) || guess < 1000 ) { er.Error();}
                else {guesses++;
                        boolean guessed = false;

                        for(int i= 0;i < 4;i++){
                            if(guessStr.charAt(i) == gen.numbStr.charAt(i)){
                                bullcount++;
                            }else if(gen.numbStr.contains(guessStr.charAt(i)+"")){
                                cowcount++;
                            }
                        }
                        if(bullcount == 4){
                            guessed = true;

                        }if(guessed == true){
                            showMessageDialog(null,"Ви виграли за " +guesses +" спроб!");
                        }
                        model.insertRow(model.getRowCount(),new Object[]{guesses,guessStr, cowcount, bullcount});
                        cowcount = 0;
                        bullcount = 0;}
                }catch(InputMismatchException | NumberFormatException es) {


            }
            }





    }


    public static void main(String args[]) {


        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reader().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private static int sizeWidth;
    private static int sizeHeight;
    GiveUp stand = new GiveUp();
    private int  locationX;
    private int locationY;
    protected int bullcount = 0;
    protected int cowcount = 0;
    protected int guesses = 0;
    protected DefaultTableModel model;

    //Input in = new Input();
    ErrorType er = new ErrorType();
    GenerateNumb gen = new GenerateNumb();
    private javax.swing.JTextField jTextField1;
}




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
        }}
class JComponentTableCellRenderer implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        return (JComponent) value;
    }
}






