package view;

import logics.Controll;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class WithComp extends JFrame {
    final private JScrollPane jScrollPane1 = new JScrollPane();
    final private JComboBox<String> jComboBox1 = new JComboBox<>();
    final private JButton input = new JButton();
    final private JButton newGame = new JButton();
    final private JButton backMenu = new JButton();
    final private JLabel numbCountLabel = new JLabel();
    final private JLabel timerLabel = new JLabel();
    final private JLabel settingsLabel = new JLabel();
    final private JPanel settings = new JPanel();
    final private  Font font = new Font("Tahoma", 0, 14);
    private JPasswordField pass = new JPasswordField();


    public WithComp() {
        initComponents();
        table();
        screen();
        startFrame();}

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
        sizeWidth = 600;
        sizeHeight = 600;
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);
    }

    private void table() {
         DefaultTableModel model;
        String headers[] = {"Cпроба", "Число", "", ""};
        final Object rows[][] = {};
        model = new DefaultTableModel(rows, headers) {
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

    private void initComponents() {
        numbCountLabel.setText("Кількість цифр у числі");
        timerLabel.setText("Таймер");
        settingsLabel.setText("Налаштування");
        backMenu.setFont(font);
        input.setFont(font);
        newGame.setFont(font);
        timerLabel.setFont(font);
        numbCountLabel.setFont(font);
        settingsLabel.setFont(font);
        jComboBox1.setSelectedItem("4");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6" }));
        backMenu.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backMenuActionPerformed(evt);
            }
        });
        KeyListener listener = new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }};
        pass.addKeyListener(listener);

        input.setText("Загадати!");
        input.setPreferredSize(new java.awt.Dimension(100, 30));

        newGame.setText("Нова Гра");
        newGame.setPreferredSize(new java.awt.Dimension(100, 30));

        backMenu.setText("Повернутись до меню");
        backMenu.setPreferredSize(new java.awt.Dimension(160, 30));
    }

    private void startFrame() {
        javax.swing.GroupLayout settingsLayout = new javax.swing.GroupLayout(settings);
        settings.setLayout(settingsLayout);
        settingsLayout.setHorizontalGroup(
                settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(settingsLayout.createSequentialGroup()
                                .addGroup(settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(settingsLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(settingsLabel))
                                        .addGroup(settingsLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(numbCountLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        settingsLayout.setVerticalGroup(
                settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(settingsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(settingsLabel)
                                .addGap(30, 30, 30)
                                .addGroup(settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numbCountLabel)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(timerLabel)
                                .addContainerGap(258, Short.MAX_VALUE))
        );

        jComboBox1.getAccessibleContext().setAccessibleParent(settings);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(backMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25)
                                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(newGame, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 14, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)
                                                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(input)
                                        .addComponent(newGame)
                                        .addComponent(backMenu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))
        );

        pack();
    }

    private void backMenuActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        Controll.menu();
    }


}
