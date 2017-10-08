package Interface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

    public class First extends javax.swing.JFrame {
        public First () {
            initComponents();
        }
        private void initComponents() {
            start = new javax.swing.JButton();
            exit = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            stabilization();
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Бики та корови");setResizable(false);setVisible(true);
            try {
                setIconImage(ImageIO.read(new File("res/bicho1.png")));
            }
            catch (IOException exc) {
                exc.printStackTrace();
            }

            start.setText("Почати гру");
            start.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    startActionPerformed(evt);
                }
            });
            exit.setText("Вихід");
            exit.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 0, Short.MAX_VALUE)
            );

            jLabel2.setText("jLabel2");
            jLabel2.setIcon(new ImageIcon("E:\\GIT\\BullsAndCows\\src\\res\\21.png"));

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(start)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(exit)
                                                    .addGap(10, 10, 10)))
                                    .addGap(243, 243, 243))
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(start)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(exit)
                                    .addGap(36, 36, 36))
            );

            pack();
        }
        public  void stabilization(){
            int sizeWidth;
            int sizeHeight;
            int  locationX;
            int locationY;
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            sizeWidth = 600;
            sizeHeight = 500;
            locationX = (screenSize.width - sizeWidth) / 2;
            locationY = (screenSize.height - sizeHeight) / 2;
            setBounds(locationX, locationY, sizeWidth, sizeHeight);

        }
        private void startActionPerformed(java.awt.event.ActionEvent e) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    dispose();
                    new Reader().setVisible(true);
                }
            });
            }
        private void exitActionPerformed(java.awt.event.ActionEvent e) {
            dispose();}
        public static void main(String args[]) {

            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(First.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new First().setVisible(true);
                }
            });
        }

        private javax.swing.JButton start;
        private javax.swing.JButton exit;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;

    }


