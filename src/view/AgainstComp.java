package view;

import logics.Condition;
import logics.Controll;
import logics.DigitFilter;
import logics.GenerateNumb;

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

public class AgainstComp extends javax.swing.JFrame {
    GenerateNumb gen = new GenerateNumb();
    final private ErrorType er = new ErrorType();
    final private Condition cond = new Condition();
    final private JButton input = new JButton();
    final private JButton backMenu = new JButton();
    final private JButton capitulate = new JButton();
    final private JButton newGame = new JButton();
    final private JLabel numbCountLabel = new JLabel();
    final private JLabel timerl = new JLabel();
    final private JLabel settingsLabel = new JLabel();
    final private JPanel settings = new JPanel();
    final private JScrollPane jScrollPane1 = new JScrollPane();
    final private JTable jTable1 = new JTable();
    final private Font font = new Font("Tahoma", 0, 14);
    final private JComboBox<String> jComboBox1 = new JComboBox<>();
    private DefaultTableModel model;
    private JTextField jTextField1 = new JTextField();

    public AgainstComp() {
        initComponents();
        table();
        screen();
        startFrame();

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
        sizeWidth = 600;
        sizeHeight = 600;
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);
    }

    private void table() {
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
        backMenu.setFont(font);
        backMenu.setText("Повернутись до меню");
        timerl.setFont(font);
        numbCountLabel.setFont(font);
        timerl.setFont(font);
        settingsLabel.setFont(font);
        input.setFont(font);
        newGame.setFont(font);
        capitulate.setFont(font);
        numbCountLabel.setText("Кількість цифр у числі");
        timerl.setText("Таймер");
        settingsLabel.setText("Налаштування");
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"3", "4", "5", "6"}));
        jComboBox1.setSelectedItem("4");
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        PlainDocument doc = (PlainDocument) jTextField1.getDocument();
        doc.setDocumentFilter(new DigitFilter());
        input.setText("Ввід");
        input.setToolTipText("Якщо впевнені");
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
        backMenu.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backMenuActionPerformed(evt);
            }
        });
    }

    private void endGame() {
        cond.setSize(Integer.parseInt(jComboBox1.getSelectedItem().toString()));
        cond.setGuesses(0);
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        gen.getNumber(cond);
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
                                                        .addComponent(timerl, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(timerl)
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
                                                .addComponent(backMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(capitulate)
                                                .addGap(25, 25, 25)
                                                .addComponent(newGame)
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
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(input)
                                        .addComponent(capitulate)
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

    private void inputActionPerformed(java.awt.event.ActionEvent e) {
        if (jTextField1.getText().isEmpty()) {
            er.Error1();
        } else {
            cond.setGuessStr(jTextField1.getText());
            cond.cond(gen);
            model.insertRow(model.getRowCount(), new Object[]{cond.getGuesses(), cond.getGuessStr(), cond.getBullcount(), cond.getCowcount()});
            cond.setCowcount(0);
            cond.setBullcount(0);
        }
        ;
    }

    private void newGameActionPerformed(java.awt.event.ActionEvent e) {
        endGame();
    }

    private void capitulateActionPerformed(java.awt.event.ActionEvent e) {
        er.GiveUp(gen);
        endGame();
    }
    private void backMenuActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        Controll.menu();
    }
}


