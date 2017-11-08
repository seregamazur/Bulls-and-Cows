package view;

import logics.Face;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainMenu extends JFrame {
    Face face = new Face();
    final private JButton players = new JButton();
    final private JButton exit = new JButton();
    final private JButton againstcomp = new JButton();
    final private JButton withcomp = new JButton();
    final private JButton settings = new JButton();
    final private JLabel label = new JLabel();

    public MainMenu() {
        initComponents();
        screen();
        startFrame();
    }

    public void initComponents() {
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
        settings.setText("Налаштування");
        againstcomp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                againstcompActionPerformed(evt);
            }
        });
        settings.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });
        withcomp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                withcompActionPerformed(evt);
            }
        });
    }

    private void screen() {
        final int sizeWidth;
        final int sizeHeight;
        final int locationX;
        final int locationY;
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Бики та корови");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("res/bicho1.png")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        sizeWidth = 541;
        sizeHeight = 431;
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);

    }

    private void exitActionPerformed(java.awt.event.ActionEvent e) {
        System.exit(0);

    }

    private void againstcompActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        face.start();
    }
    private void settingsActionPerformed(java.awt.event.ActionEvent e) {
        setFocusableWindowState(false);
        readUserSettings();


    }

    private void withcompActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        face.start1();

    }


    private void startFrame() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(208, 208, 208)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(withcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(againstcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(againstcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(withcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );

        pack();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    private void readUserSettings(){
        Settings set = new Settings();
        Properties props = new Properties();
        InputStream input = null;

        try {
            File f = new File("settings.ini");
            input = new FileInputStream(f);

            props.load(input);
            set.getTimer().setSelected(Boolean.valueOf(props.getProperty("TimerSet")));
            set.getjComboBox1().setSelectedItem(props.getProperty("DigitsCount"));
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
