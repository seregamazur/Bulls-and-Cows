package view;

import controller.Controll;
import model.Guessing;
import model.InputGetter;
import utils.CheckNumber;
import utils.ErrorType;
import utils.GeneratorNumber;
import utils.JComponentTableCellRenderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class AgainstComp extends JFrame {
    private final ScreenLocation size = new ScreenLocation();
    private final Guessing guessing = new Guessing();
    private InputGetter getter = new InputGetter();
    private final GeneratorNumber gen = new GeneratorNumber();
    private final JButton input = new JButton();
    private final JButton backMenu = new JButton();
    private final JButton capitulate = new JButton();
    private final JButton newGame = new JButton();
    private final JLabel numbCountLabel = new JLabel();
    private final JLabel timerLabel = new JLabel();
    private final JLabel settingsLabel = new JLabel();
    private final JScrollPane jScrollPane1 = new JScrollPane();
    private final Font font = new Font("Tahoma", 0, 14);
    private DefaultTableModel model;
    private JTextField jTextField1 = new JTextField();

    public AgainstComp() {
        initComponents();
        table();
        size.setWindowLocation(45,40);
        startFrame();

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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < 4; i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        Icon cowIcon = new ImageIcon("src/resources/cowTable.png");
        Icon bullIcon = new ImageIcon("src/resources/bullTable.png");
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
        backMenu.setText("Повернутись до меню");
        timerLabel.setFont(font);
        numbCountLabel.setFont(font);
        timerLabel.setFont(font);
        settingsLabel.setFont(font);
        input.setFont(font);
        newGame.setFont(font);
        capitulate.setFont(font);
        numbCountLabel.setText("Кількість цифр у числі");
        timerLabel.setText("Таймер");
        settingsLabel.setText("Налаштування");
        input.setText("Ввід");
        input.setToolTipText("Якщо впевнені");
        jTextField1.setFont(new Font("Tahoma", 0, 14));

        KeyListener listener = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        };
        jTextField1.addKeyListener(listener);


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
        backMenu.setPreferredSize(new Dimension(180, 30));
        jScrollPane1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private void endGame() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        gen.getNumber();
    }

    private void startFrame() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backMenu, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(capitulate)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newGame)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(64, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(input)
                                        .addComponent(capitulate)
                                        .addComponent(newGame)
                                        .addComponent(backMenu))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        setBounds(size.getLocationX(),size.getLocationY(),size.getWidth(),size.getHeight());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Загадати число");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("src/resources/icon.png")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        pack();
        gen.read();
        endGame();
    }

    private void inputActionPerformed(ActionEvent e) {
        if (jTextField1.getText().isEmpty()) {
            ErrorType.emptyType();
        } else {
            if (guessing.getUsageNumbers().contains(Integer.parseInt(jTextField1.getText()))) {
                ErrorType.sameType();
                jTextField1.setText(null);
                return;
            } else {
                getter.setInputNumb(Integer.parseInt(jTextField1.getText()));
            }
        }
        if (Integer.valueOf(getter.getInputNumb()).toString().length() != gen.getDigits() || !CheckNumber.hasNoDupes(getter.getInputNumb())) {
            ErrorType.incType(gen);
        } else {
            guessing.Check(gen, getter);
            model.insertRow(model.getRowCount(), new Object[]{guessing.getGuesses(), guessing.getNumbers().getLast().getNumber(), guessing.getNumbers().getLast().getBullCount(), guessing.getNumbers().getLast().getCowCount()});
            jTextField1.setText(null);

        }

        if (guessing.getGenerateStatus() == Guessing.GenerateStatus.FINISHED) {
            JOptionPane.showMessageDialog(null, "Ви відгадали число за  " + guessing.getGuesses() + " спроб!");
            input.setEnabled(false);
            jTextField1.setEnabled(false);
            capitulate.setEnabled(false);
        }
    }

    private void newGameActionPerformed(ActionEvent e) {
        jTextField1.setText(null);
        jTextField1.setEnabled(true);
        input.setEnabled(true);
        capitulate.setEnabled(true);
        guessing.getUsageNumbers().clear();
        endGame();
    }

    private void capitulateActionPerformed(ActionEvent e) {
        ErrorType.giveUp(gen);
        jTextField1.setText(null);
        endGame();
    }

    private void backMenuActionPerformed(ActionEvent e) {
        guessing.getUsageNumbers().clear();
        dispose();
        Controll.menu();
    }

}