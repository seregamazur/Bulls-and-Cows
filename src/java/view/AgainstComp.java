package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class AgainstComp extends JFrame implements Serializable {
    private static final long serialVersionUID = 2405172041950251805L;

    public void initAgainstComp() {
        try {
            Pane rootLayout;
            Stage primaryStage = new Stage();
            URL url = new File("src/resources/fxml/AgainstComp.fxml").toURI().toURL();
            rootLayout = FXMLLoader.load(url);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Вiдгадати число");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



















    /*private final ScreenLocation size = new ScreenLocation();
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
    private final Font tahomaFont = new Font("Tahoma", Font.PLAIN, 14);
    private DefaultTableModel model;
    private JTextField jTextField1 = new JTextField();

    public AgainstComp() {
        initComponents();
        table();
        size.setWindowLocation(45, 40);
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
        backMenu.setText("Повернутись до меню");
        timerLabel.setFont(tahomaFont);
        numbCountLabel.setFont(tahomaFont);
        timerLabel.setFont(tahomaFont);
        settingsLabel.setFont(tahomaFont);
        input.setFont(tahomaFont);
        newGame.setFont(tahomaFont);
        capitulate.setFont(tahomaFont);
        numbCountLabel.setText("Кількість цифр у числі");
        timerLabel.setText("Таймер");
        settingsLabel.setText("Налаштування");
        input.setText("Ввід");
        input.setToolTipText("Якщо впевнені");
        jTextField1.setFont(tahomaFont);

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


        input.addActionListener(evt -> inputActionPerformed());
        capitulate.setText("Здаюсь");
        capitulate.addActionListener(evt -> capitulateActionPerformed());
        newGame.setText("Нова гра");
        newGame.addActionListener(evt -> newGameActionPerformed());
        backMenu.addActionListener(evt -> backMenuActionPerformed());
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
        setBounds(size.getLocationX(), size.getLocationY(), size.getWidth(), size.getHeight());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Загадати число");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("src/resources/icon.png")));
        } catch (IOException exc) {
            java.util.logging.Logger.getLogger(AgainstComp.class.getName()).log(java.util.logging.Level.SEVERE, null, exc);
        }
        pack();
        gen.read();
        endGame();
    }

    private void inputActionPerformed() {
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Вами не було введено число.");
        } else {
            if (guessing.getUsageNumbers().contains(Integer.parseInt(jTextField1.getText()))) {
                JOptionPane.showMessageDialog(null,
                        "Ви вже вводили дане число");
                jTextField1.setText(null);
                return;
            } else {
                getter.setInputNumb(Integer.parseInt(jTextField1.getText()));
            }
        }
        if (Integer.toString(getter.getInputNumb()).length() != gen.getDigits() || !CheckerNumber.hasNoDupes(getter.getInputNumb())) {
            JOptionPane.showMessageDialog(null,
                    "Ви задали число неправильно формату.\nКількість цифр в числі правильного формату: " + gen.getDigits());
        } else {
            guessing.check(gen, getter);
            model.insertRow(model.getRowCount(), new Object[]{guessing.getGuesses(), guessing.getNumbers().getLast().getDigit(), guessing.getNumbers().getLast().getBullCount(), guessing.getNumbers().getLast().getCowCount()});
            jTextField1.setText(null);

        }

        if (guessing.getGenerateStatus() == Guessing.GenerateStatus.FINISHED) {
            JOptionPane.showMessageDialog(null, "Ви відгадали число за  " + guessing.getGuesses() + " спроб!");
            input.setEnabled(false);
            jTextField1.setEnabled(false);
            capitulate.setEnabled(false);
        }
    }

    private void newGameActionPerformed() {
        jTextField1.setText(null);
        jTextField1.setEnabled(true);
        input.setEnabled(true);
        capitulate.setEnabled(true);
        guessing.getUsageNumbers().clear();
        endGame();
    }

    private void capitulateActionPerformed() {
        JOptionPane.showMessageDialog(null,
                "Ви програли!\nПравильним числом було:" + gen.getGeneratedNumber());
        jTextField1.setText(null);
        endGame();
    }

    private void backMenuActionPerformed() {
        guessing.getUsageNumbers().clear();
        dispose();
        Controller.menu();
    }
    */

