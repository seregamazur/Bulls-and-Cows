package view;

import controller.Controll;
import model.ComputerGenerator;
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

import static model.ComputerGenerator.GenerateStatus.FINISHED;
import static model.ComputerGenerator.GenerateStatus.GENERATING;

public class WithComp extends JFrame {
    private final ScreenLocation size = new ScreenLocation();
    private InputGetter getter = new InputGetter();
    private final ComputerGenerator computerGenerator = new ComputerGenerator();
    private final ErrorType er = new ErrorType();
    private final GeneratorNumber gen = new GeneratorNumber();
    private final JScrollPane jScrollPane1 = new JScrollPane();
    private final JButton input = new JButton();
    private final JButton newGame = new JButton();
    private final JButton backMenu = new JButton();
    private final JLabel numbCountLabel = new JLabel();
    private final JLabel timerLabel = new JLabel();
    private final JLabel settingsLabel = new JLabel();
    private final Font font = new Font("Tahoma", 0, 14);
    private JTextField jTextField1 = new JTextField();
    private DefaultTableModel model;


    public WithComp() {
        initComponents();
        table();
        size.setWindowLocation(40,35);
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Загадати число");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("src/resources/icon.png")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        setBounds(size.getLocationX(),size.getLocationY(),size.getWidth(),size.getHeight());
        pack();
    }

    private void backMenuActionPerformed(ActionEvent e) {
        dispose();
        Controll.menu();
    }

    private void inputActionPerformed(ActionEvent e) {
        gen.read();//read the right count of the generating digits
        //make this count as variable
        if (jTextField1.getText().isEmpty()) {//start check type of the inputted numb
            er.emptyType();//if field is empty
        } else {
            getter.setInputNumber(Integer.parseInt(jTextField1.getText()));//set data from the field to variable
            if ( Integer.valueOf(getter.getInputNumber()).toString().length() != gen.getDigits() || (!CheckNumber.hasNoDupes(getter.getInputNumber()))) {
                er.incType(gen);//if inputted data included dupes or incorrect length
            } else {
                while (computerGenerator.getGenerateStatus() != FINISHED) {//start generate&input into the table
                    computerGenerator.generateAndCheck(gen);//generation
                    model.insertRow(model.getRowCount(), new Object[]{computerGenerator.getMoves().size(),
                            computerGenerator.getMoves().getLast().getNumber(),
                            computerGenerator.getMoves().getLast().getBullCount(),
                            computerGenerator.getMoves().getLast().getCowCount()});

                }

            }
        }
        if (computerGenerator.getGenerateStatus() == FINISHED) {//the end of the game
            JOptionPane.showMessageDialog(null, "Комп'ютер відгадав ваше число за " + computerGenerator.getMoves().size() + " спроб!");
            input.setEnabled(false);
            jTextField1.setEnabled(false);
            computerGenerator.getMoves().clear();
            computerGenerator.getNumbers().clear();
            computerGenerator.setGenerateStatus(GENERATING);
        }
    }


    private void newGameActionPerformed(ActionEvent e) {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        jTextField1.setText(null);
        jTextField1.setEnabled(true);
        input.setEnabled(true);
        computerGenerator.getMoves().clear();
        computerGenerator.getNumbers().clear();
    }


}
