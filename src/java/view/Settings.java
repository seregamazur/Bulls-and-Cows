package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class Settings extends JDialog {
    private JComboBox getjComboBox1() {
        return jComboBox1;
    }
    private final ScreenLocation screen = new ScreenLocation();
    private JComboBox jComboBox1 = new JComboBox<>();
    private final JLabel settingsLabel = new JLabel();
    private final JLabel numbCountLabel = new JLabel();
    private final JButton exit = new JButton();
    private final JButton save = new JButton();

    public Settings() {
        initComponents();
        startFrame();
        readUserSettings();
        screen();


    }

    private void initComponents() {
        settingsLabel.setText("Налаштування");
        exit.setText("Вихід");
        save.setText("Зберегти зміни");
        numbCountLabel.setText("Кількість цифр в числі");
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"3", "4", "5", "6"}));
        jComboBox1.setSelectedItem("4");
        exit.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        save.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
    }

    private void screen() {
        screen.setWindowLocation(20,20);

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setTitle("Налаштування");
        setResizable(true);
        try {
            setIconImage(ImageIO.read(new File("src/resources/icon.png")));
        } catch (IOException exc) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, exc);
        }
        setBounds(screen.getLocationX(),screen.getLocationY(),screen.getWidth(),screen.getHeight());
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(true);


    }

    private void exitActionPerformed(java.awt.event.ActionEvent e) {
        setVisible(false);

    }

    private void saveActionPerformed(java.awt.event.ActionEvent e) {
        writeUserSettings();
        setVisible(false);

    }

    private void startFrame() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(numbCountLabel)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                // .addComponent(timerLabel)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                                                                //.addComponent(timer)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(save)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(exit)
                                                                .addGap(20, 20, 20))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(settingsLabel)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(settingsLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(numbCountLabel)
                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
                                //.addComponent(timer)
                                // .addComponent(timerLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(save)
                                        .addComponent(exit))
                                .addContainerGap())
        );

        pack();
    }

    private void writeUserSettings() {
        try {
            String numbCount = "DigitsCount";
            //String timerBool = "TimerSet";
            Properties props = new Properties();
            props.setProperty(numbCount, getjComboBox1().getSelectedItem().toString());
            File f = new File("settings.properties");
            OutputStream out = new FileOutputStream(f);
            props.store(out, null);
            out.close();
        } catch (Exception io) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, io);
        }

    }

    private void readUserSettings() {
        Properties props = new Properties();
        InputStream input;
        try {
            File f = new File("settings.properties");
            input = new FileInputStream(f);

            props.load(input);
            getjComboBox1().setSelectedItem(props.getProperty("DigitsCount"));
            input.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
