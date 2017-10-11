package Interface;

import Logic.Condition;
import Logic.DigitFilter;
import Logic.GenerateNumb;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Window2 extends javax.swing.JFrame {
     GenerateNumb gen = new GenerateNumb();
        final ErrorType er = new ErrorType();
        final Condition cond = new Condition();
       final JButton input = new JButton();
        final JButton capitulate = new JButton();
        final JButton newGame = new JButton();
        final JButton exit = new JButton();
        final JScrollPane jScrollPane1 =  new JScrollPane();
        final JTable jTable1 = new JTable();
        DefaultTableModel model;

    JTextField jTextField1 = new JTextField();
        public void Window2(){
            initComponents();
            table();
            screen();
            startFrame();

        }
    private void screen(){
        final int sizeWidth;
        final int sizeHeight;
        final int  locationX;
        final int locationY;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Бики та корови");setResizable(false);setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("res/bicho1.png")));
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        sizeWidth = 600;
        sizeHeight = 600;
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);
    }
        private void table(){
            String headers[] = { "Cпроба", "Число","","" };
            final Object rows[][] = {};
            model=new DefaultTableModel(rows,headers){
                public boolean isCellEditable(int row, int headers) {
                    return false;
                }
            };
            JTable jTable1 = new JTable(model);
            jScrollPane1.setViewportView(jTable1);
            Icon cowIcon = new ImageIcon("res/korovka.png");
            Icon bullIcon = new ImageIcon("res/bichochok.png");
            Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
            JLabel cowLabel = new JLabel(headers[3], cowIcon, JLabel.CENTER);
            cowLabel.setBorder(headerBorder);
            JLabel bullLabel = new JLabel(headers[2], bullIcon, JLabel.CENTER);
            bullLabel.setBorder(headerBorder);
            TableCellRenderer renderer = new JComponentTableCellRenderer();
            TableColumnModel columnModel = jTable1.getColumnModel();
            TableColumn column3 = columnModel.getColumn(3);
            TableColumn column2 = columnModel.getColumn(2);
            column3.setHeaderRenderer(renderer);
            column3.setHeaderValue(cowLabel);
            column2.setHeaderRenderer(renderer);
            column2.setHeaderValue(bullLabel);
        }
        private void initComponents(){
            jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14));
            PlainDocument doc = (PlainDocument) jTextField1.getDocument();
            doc.setDocumentFilter(new DigitFilter());
            input.setText("Ввід");input.setToolTipText("Якщо впевнені");
            input.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    inputActionPerformed(evt);
                }
            });
            capitulate.setText("Здаюсь");
            capitulate.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    capitulateActionPerformed(evt);
                }
            });
            newGame.setText("Нова гра");
            newGame.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    newGameActionPerformed(evt);
                }
            });
            exit.setText("Вихід");
            exit.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitActionPerformed(evt);
                }
            });
            gen.getNumber();
        }
        private void endGame(){
            cond.setGuesses(0);
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            gen.getNumber();
        }
        private void startFrame(){
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
                                                    .addComponent(input, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(capitulate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(2, 2, 2)
                                                    .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(input)
                                            .addComponent(capitulate)
                                            .addComponent(newGame)
                                            .addComponent(exit))
                                    .addGap(30, 30, 30)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            pack();
        }
        private void exitActionPerformed(java.awt.event.ActionEvent e) {
            dispose();}

        private void inputActionPerformed(java.awt.event.ActionEvent e) {
            if(jTextField1.getText().isEmpty()){er.Error1();}
            else{cond.setGuessStr(jTextField1.getText());
                cond.cond(gen);
                model.insertRow(model.getRowCount(),new Object[]{cond.getGuesses(),cond.getGuessStr(),cond.getBullcount(),cond.getCowcount()});
                        cond.setCowcount(0);
                        cond.setBullcount(0);
        }
                   ;}
    private void newGameActionPerformed(java.awt.event.ActionEvent e) {
       endGame();
    }
    private void capitulateActionPerformed(java.awt.event.ActionEvent e) {
        er.GiveUp(gen);
        endGame();
        }
            }


