package view;

import logics.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class WithComp extends JFrame {
    private int gem;
    private String finalStr;
    public void setFinalStr(String finalStr) {
        this.finalStr = finalStr;
    }
        public String getFinalStr() {
        return finalStr;}
//    final private Move move = new Move();
    final private ErrorType er = new ErrorType();
    final private GenerateNumb gen = new GenerateNumb();
    final private JScrollPane jScrollPane1 = new JScrollPane();
    final private JButton input = new JButton();
    final private JButton newGame = new JButton();
    final private JButton backMenu = new JButton();
    final private JLabel numbCountLabel = new JLabel();
    final private JLabel timerLabel = new JLabel();
    final private JLabel settingsLabel = new JLabel();
    final private Condition cond = new Condition();
    final private Font font = new Font("Tahoma", 0, 14);
    private JTextField jTextField1 = new JTextField();
    private DefaultTableModel model;


    public WithComp() {
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Загадати число");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("res/bicho1.png")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        sizeWidth = 500;
        sizeHeight = 359;
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
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0;i<4;i++){
        jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
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
        backMenu.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backMenuActionPerformed(evt);
            }
        });
        input.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });
        newGame.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        KeyListener listener = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        };
        jTextField1.addKeyListener(listener);

        input.setText("Загадати!");
        input.setPreferredSize(new Dimension(100, 30));

        newGame.setText("Нова Гра");
        newGame.setPreferredSize(new Dimension(100, 30));

        backMenu.setText("Повернутись до меню");
        backMenu.setPreferredSize(new Dimension(180, 30));
        jScrollPane1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private void startFrame() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newGame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(52, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newGame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }

    private void backMenuActionPerformed(ActionEvent e) {
        setVisible(false);
        Controll.menu();
    }

    private void inputActionPerformed(ActionEvent e) {
        gen.read(cond);
        if (jTextField1.getText().isEmpty()) {
            er.Error1();
        } else {
            cond.setGuessStr(jTextField1.getText());

            if (Integer.valueOf(cond.getGuessStr().length()) != cond.getSize() || gen.hasDupes(Integer.valueOf(cond.getGuessStr()))) {
                er.Error(cond);
            } else {
                while (!cond.isGuessed()) {
                    gen.getNumb(cond);
                    cond.comp(gen);
                    if (cond.getExceptedNumb().contains(gen.getNumbStr()) || (cond.getCowcount() == 0 && cond.getBullcount() == 0)) {
                        ;
                    } else {
                        if( !cond.isGuessed() && cond.getCowcount() == cond.getSize()){
                            gem = Integer.parseInt(this.gen.getNumbStr());
                            model.insertRow(model.getRowCount(), new Object[]{cond.getGuesses(), gen.getNumbStr(), cond.getBullcount(), cond.getCowcount()});
                                cond.setCowcount(0);
                            cond.setBullcount(0);
                            cond.setGuesses(cond.getGuesses()+1);
                            int[]digits = this.gen.getNumbStr().chars().map(c -> c-='0').toArray();
                            StringBuilder builder = new StringBuilder();
                            for (int i : digits) {
                                builder.append(i);
                            }
                            setFinalStr(builder.toString());

                            while(!getFinalStr().equals(cond.getGuessStr())){nextPermutation(digits);
                                for (int i : digits) {
                                    builder.append(i);
                                }
                                setFinalStr(builder.toString());
                            for (int i = 0; i < cond.getSize(); i++) {
                                if (cond.getGuessStr().charAt(i) == Arrays.toString(digits).charAt(i)) {
                                    cond.setBullcount(cond.getBullcount()+1);
                                } else if (cond.getGuessStr().contains(Arrays.toString(digits).charAt(i) + "")) {
                                    cond.setCowcount(cond.getCowcount()+1);
                                }
                            }}
                                model.insertRow(model.getRowCount(), new Object[]{cond.getGuesses()+1, getFinalStr(), cond.getBullcount(), cond.getCowcount()});
                        } else{
                        model.insertRow(model.getRowCount(), new Object[]{cond.getGuesses(), gen.getNumbStr(), cond.getBullcount(), cond.getCowcount()});
                        cond.setCowcount(0);
                        cond.setBullcount(0);
                    }
                }
            }}
        if(cond.isGuessed()){
            input.setEnabled(false);
            jTextField1.setEnabled(false);}
    }}

    private void newGameActionPerformed(ActionEvent e) {
        cond.setGuesses(0);
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        jTextField1.setText(null);
        jTextField1.setEnabled(true);
        input.setEnabled(true);
        cond.setGuessStr(null);
        cond.setGuessed(false);
    }
    public void nextPermutation(int[] digits) {
        int i = digits.length - 2;
        while (i >= 0 && digits[i + 1] <= digits[i]) {
            i--;
        }
        if (i >= 0) {
            int j = digits.length - 1;
            while (j >= 0 && digits[j] <= digits[i]) {
                j--;
            }
            swap(digits, i, j);
        }
        reverse(digits, i + 1);
    }

    private void reverse(int[] digits, int start) {
        int i = start, j = digits.length - 1;
        while (i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] digits, int i, int j) {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }



}
