package view;

import controller.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import utils.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;

import static model.ComputerGenerator.GenerateStatus.FINISHED;
import static model.ComputerGenerator.GenerateStatus.GENERATING;

public class WithComp implements Serializable {
    private static final long serialVersionUID = 2405172041950251802L;
   /* private final ScreenLocation size = new ScreenLocation();
    private final ComputerGenerator computerGenerator = new ComputerGenerator();
    private final GeneratorNumber gen = new GeneratorNumber();
    private final JScrollPane jScrollPane1 = new JScrollPane();
    private final JButton input = new JButton();
    private final JButton newGame = new JButton();
    private final JButton backMenu = new JButton();
    private final JLabel numbCountLabel = new JLabel();
    private final JLabel timerLabel = new JLabel();
    private final JLabel settingsLabel = new JLabel();
    private final Font tahomaFont = new Font("Tahoma", Font.PLAIN, 14);
    private JTextField jTextField1 = new JTextField();
    private DefaultTableModel model;


    public WithComp() {
        initComponents();
        table();
        size.setWindowLocation(40, 35);
        startFrame();
    }

    private void table() {
        String[] headers = {"Cпроба", "Число", "", ""};
        final Object[][] rows = {};
        model = new DefaultTableModel(rows, headers) {
            @Override
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
        backMenu.setFont(tahomaFont);
        input.setFont(tahomaFont);
        newGame.setFont(tahomaFont);
        timerLabel.setFont(tahomaFont);
        numbCountLabel.setFont(tahomaFont);
        settingsLabel.setFont(tahomaFont);
        jTextField1.setFont(tahomaFont);
        backMenu.addActionListener(evt -> backMenuActionPerformed());
        input.addActionListener(evt -> inputActionPerformed());
        newGame.addActionListener(evt -> newGameActionPerformed());
        KeyListener listener = new KeyAdapter() {
            @Override
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
            java.util.logging.Logger.getLogger(WithComp.class.getName()).log(java.util.logging.Level.SEVERE, null, exc);
        }
        setBounds(size.getLocationX(), size.getLocationY(), size.getWidth(), size.getHeight());
        pack();
    }

    private void backMenuActionPerformed() {
        dispose();
        Controller.menu();
    }*/
   public void initWithComp(){
       try {
           Pane rootLayout;
           Stage primaryStage = new Stage();
           URL url = new File("src/resources/fxml/WithComp.fxml").toURI().toURL();
           rootLayout = FXMLLoader.load(url);
           Scene scene = new Scene(rootLayout);
           primaryStage.setScene(scene);
           primaryStage.setTitle("Загадати число");

           primaryStage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }}

   /*
    private void inputActionPerformed() {
        gen.read();//read the right count of the generating digits
        //make this count as variable
        if (jTextField1.getText().isEmpty()) {//start check type of the inputted numb
            JOptionPane.showMessageDialog(null,
                    "Вами не було введено число.");
//if field is empty
        } else {
            InputGetter.setInputNumber(Integer.parseInt(jTextField1.getText()));//set data from the field to variable
            if (Integer.toString(InputGetter.getInputNumber()).length() != gen.getDigits() || (!CheckerNumber.hasNoDupes(InputGetter.getInputNumber()))) {
                JOptionPane.showMessageDialog(null,
                        "Ви задали число неправильно формату.\nКількість цифр в числі правильного формату: " + gen.getDigits());
//if inputted data included dupes or incorrect length
            } else {
                while (computerGenerator.getGenerateStatus() != FINISHED) {//start generate&input into the table
                    computerGenerator.generateAndCheck(gen);//generation
                    model.insertRow(model.getRowCount(), new Object[]{computerGenerator.getMoves().size(),
                            computerGenerator.getMoves().getLast().getDigit(),
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


    private void newGameActionPerformed() {
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

*/

