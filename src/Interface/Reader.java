//package Interface;
//import Logic.GenerateNumb;
//import Logic.DigitFilter;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.IOException;
//import java.util.InputMismatchException;
//import javax.swing.*;
//import javax.imageio.ImageIO;
//import javax.swing.border.Border;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellRenderer;
//import javax.swing.table.TableColumn;
//import javax.swing.table.TableColumnModel;
//import javax.swing.text.PlainDocument;
//import static javax.swing.JOptionPane.showMessageDialog;
//public class Reader extends javax.swing.JFrame {
//
//    public Reader() {
//        initComponents();
//    }
//    public static String  guessStr ;
//    private javax.swing.JButton jButton1;
//    private javax.swing.JButton jButton2;
//    private javax.swing.JButton jButton3;
//    private javax.swing.JButton jButton4;
//    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JTable jTable1;
//    private javax.swing.JTextField jTextField1;
//    private static int sizeWidth;
//    private static int sizeHeight;
//    private int  locationX;
//    private int locationY;
//    protected int bullcount = 0;
//    protected int cowcount = 0;
//    protected int guesses = 0;
//    public DefaultTableModel model;
//    ErrorType er = new ErrorType();
//    GiveUp stand = new GiveUp();
//    GenerateNumb gen = new GenerateNumb();
//public void initComponents() {
//jButton1 = new javax.swing.JButton();
//jTextField1 = new javax.swing.JTextField();
//jButton2 = new javax.swing.JButton();
//jButton3 = new javax.swing.JButton();
//jButton4 = new javax.swing.JButton();
//jScrollPane1 = new javax.swing.JScrollPane();
//jTable1 = new javax.swing.JTable();
//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//setTitle("Бики та корови");setResizable(false);setVisible(true);
//try {
//   setIconImage(ImageIO.read(new File("res/bicho1.png")));
//}
//catch (IOException exc) {
//   exc.printStackTrace();
//}
//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//sizeWidth = 600;
//sizeHeight = 500;
//locationX = (screenSize.width - sizeWidth) / 2;
//locationY = (screenSize.height - sizeHeight) / 2;
//setBounds(locationX, locationY, sizeWidth, sizeHeight);
//jButton1.setText("Ввід");jButton1.setToolTipText("Якщо впевнені");
//jButton1.addActionListener((ActionListener) new ActionListener() {
//   public void actionPerformed(ActionEvent evt) {
//       jButton1ActionPerformed(evt);
//   }
//});
//jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14));
//PlainDocument doc = (PlainDocument) jTextField1.getDocument();
//doc.setDocumentFilter(new DigitFilter());
//jButton2.setText("Здаюсь");
//jButton2.addActionListener((ActionListener) new ActionListener() {
//    public void actionPerformed(ActionEvent evt) {
//        jButton2ActionPerformed(evt);
//    }
//});
//jButton3.setText("Нова гра");
//jButton3.addActionListener((ActionListener) new ActionListener() {
//    public void actionPerformed(ActionEvent evt) {
//        jButton3ActionPerformed(evt);
//    }
//});
//jButton4.setText("Вихід");
//jButton4.addActionListener((ActionListener) new ActionListener() {
//    public void actionPerformed(ActionEvent evt) {
//        jButton4ActionPerformed(evt);
//    }
//});
//{
//   String headers[] = { "Cпроба", "Число","","" };
//   final Object rows[][] = {};
//   model=new DefaultTableModel(rows,headers){
//       public boolean isCellEditable(int row, int headers) {
//           return false;
//       }
//   };
//   JTable jTable1 = new JTable(model);
//   jScrollPane1.setViewportView(jTable1);
//    Icon cowIcon = new ImageIcon("res/korovka.png");
//    Icon bullIcon = new ImageIcon("res/bichochok.png");
//    Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
//   JLabel cowLabel = new JLabel(headers[3], cowIcon, JLabel.CENTER);
//   cowLabel.setBorder(headerBorder);
//    JLabel bullLabel = new JLabel(headers[2], bullIcon, JLabel.CENTER);
//    bullLabel.setBorder(headerBorder);
//    TableCellRenderer renderer = new JComponentTableCellRenderer();
//    TableColumnModel columnModel = jTable1.getColumnModel();
//    TableColumn column3 = columnModel.getColumn(3);
//    TableColumn column2 = columnModel.getColumn(2);
//    column3.setHeaderRenderer(renderer);
//    column3.setHeaderValue(cowLabel);
//    column2.setHeaderRenderer(renderer);
//    column2.setHeaderValue(bullLabel);
//javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//getContentPane().setLayout(layout);
//layout.setHorizontalGroup(
//layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//        .addContainerGap()
//        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                .addGroup(layout.createSequentialGroup()
//                        .addGap(4, 4, 4)
//                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(2, 2, 2)
//                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGroup(layout.createSequentialGroup()
//                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(0, 0, Short.MAX_VALUE)))
//        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
//        .addContainerGap())
//);
//        layout.setVerticalGroup(
//    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                    .addContainerGap()
//                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(jButton1)
//                            .addComponent(jButton2)
//                            .addComponent(jButton3)
//                            .addComponent(jButton4))
//                    .addGap(30, 30, 30)
//                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
//                    .addContainerGap())
//);
//        pack();
//    }}
//    private void jButton4ActionPerformed(java.awt.event.ActionEvent e) {
//        dispose();}
//      private void jButton3ActionPerformed(java.awt.event.ActionEvent e) {
//        newgame();}
//      private void jButton2ActionPerformed(java.awt.event.ActionEvent e) {
//        stand.up();}
//      private void jButton1ActionPerformed(java.awt.event.ActionEvent e) {
//            if(jTextField1.getText().isEmpty()){er.Error1();}
//            else{
//                guessStr = jTextField1.getText();
//                guessStr.trim();
//                try{
//                    int  guess = Integer.parseInt(guessStr);
//                    if(gen.hasDupes(guess) || guess < 1000 ) { er.Error();}
//                else {guesses++;
//                        boolean guessed = false;
//                        for(int i= 0;i < 4;i++){
//                            if(guessStr.charAt(i) == gen.numbStr.charAt(i)){
//                                bullcount++;
//                            }else if(gen.numbStr.contains(guessStr.charAt(i)+"")){
//                                cowcount++;
//                            }
//                        }
//                        if(bullcount == 4){
//                            guessed = true;
//                        }if(guessed == true){
//                            showMessageDialog(null,"Ви виграли за " +guesses +" спроб!");
//                        }
//                        model.insertRow(model.getRowCount(),new Object[]{guesses,guessStr, bullcount, cowcount });
//                        cowcount = 0;
//                        bullcount = 0;}
//                }catch(InputMismatchException | NumberFormatException es) {}}
//    }
//    private void newgame(){
//        guesses = 0;
//        int rowCount = model.getRowCount();
//        for (int i = rowCount - 1; i >= 0; i--) {
//            model.removeRow(i);
//        }
//        gen.go();
//    }
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
