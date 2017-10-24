package Interface;

import Logic.GenerateNumb;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame {
     Face face = new Face();
    final JButton players = new JButton();
    final JButton exit = new JButton();
    final JButton againstcomp = new JButton();
    final JButton withcomp = new JButton();
    final JLabel label = new JLabel();
    final JPanel jPanel1 = new JPanel();
    public MainMenu(){
        initComponents();
        screen();
        startFrame();
    }
    public void initComponents(){
        label.setIcon(new ImageIcon("E:\\GIT\\BullsAndCows\\src\\res\\21.png"));
        exit.setText("Вихід");
        exit.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        players.setText("2 Гравці");
        againstcomp.setText("Відгадати число");
        withcomp.setText("Загадати число");
        againstcomp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                againstcompActionPerformed(evt);
            }
        });
        withcomp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                withcompActionPerformed(evt);
            }
        });
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
        sizeHeight = 500;
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);
    }
    private void exitActionPerformed(java.awt.event.ActionEvent e) {
        dispose();

        }
    private void againstcompActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        face.start();
}
    private void withcompActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        face.start1();
    }


private void startFrame(){
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
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(87, 87, 87)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(withcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                            .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(68, 68, 68)
                            .addComponent(againstcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                            .addGap(34, 34, 34)
                                                            .addComponent(againstcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(36, 36, 36))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18))))
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(379, 379, 379)
                                            .addComponent(withcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)))
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(20, Short.MAX_VALUE))
    );
    pack();
    try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException  | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}}}
