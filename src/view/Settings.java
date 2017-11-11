package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Settings extends JFrame {
    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    private JComboBox jComboBox1 = new JComboBox<>();
    final private JLabel settingsLabel = new JLabel();
    final private JLabel numbCountLabel = new JLabel();
    final private JLabel timerLabel = new JLabel();

    public JCheckBox getTimer() {
        return timer;
    }

    final private JCheckBox timer = new JCheckBox();
    final private JButton exit = new JButton();
    final private JButton save = new JButton();

    public Settings() {
        initComponents();
        screen();
        startFrame();
    }

    private void initComponents() {
        settingsLabel.setText("Налаштування");
        timerLabel.setText("Використовувати таймер");
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
        final int sizeWidth;
        final int sizeHeight;
        final int locationX;
        final int locationY;
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setTitle("Налаштування");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("res/bicho1.png")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        sizeWidth = 280;
        sizeHeight = 190;
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);


    }

    private void exitActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
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
                                                                                .addComponent(timerLabel)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(timer)))
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
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(timer)
                                        .addComponent(timerLabel))
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
            String timerBool = "TimerSet";
            Properties props = new Properties();
            props.setProperty(numbCount, getjComboBox1().getSelectedItem().toString());
            props.setProperty(timerBool, Boolean.toString(timer.isSelected()));
            File f = new File("settings.ini");
            OutputStream out = new FileOutputStream(f);
            props.store(out, null);
            out.close();
        } catch (Exception io) {
            io.printStackTrace();
        }

    }
}
