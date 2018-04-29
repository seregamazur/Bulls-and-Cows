package view;

import controller.ControllerSettings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.net.URL;

public class Settings  implements Serializable {
    private static final long serialVersionUID = 2405172041950251803L;

    /* private final ScreenLocation screen = new ScreenLocation();
        private JComboBox jComboBox1 = new JComboBox<>();
        private final JLabel settingsLabel = new JLabel();
        private final JLabel numbCountLabel = new JLabel();
        private final JButton exit = new JButton();
        private final JButton save = new JButton();
        private JComboBox getjComboBox1() {
            return jComboBox1;
        }

        public Settings() {
            initComponents();
            startFrame();
            readUserSettings();
            screen();


        }
    */
   public void initSettings(){
       try {
           final ControllerSettings contr = new ControllerSettings();
           Pane rootLayout;
           Stage primaryStage = new Stage();
           primaryStage.initModality(Modality.APPLICATION_MODAL);
           primaryStage.setTitle("Змiнити налаштування");
           URL url = new File("src/resources/fxml/Settings.fxml").toURI().toURL();
           rootLayout = FXMLLoader.load(url);
           ObservableList<String> digits = FXCollections.observableArrayList("3","4","5","6");
           ChoiceBox<String> choiceBox = new ChoiceBox<>(digits);
           Button savechangesbutton = new Button();
           savechangesbutton.setLayoutX(117);
           savechangesbutton.setLayoutY(138);
           savechangesbutton.setText("Зберегти");
           savechangesbutton.setOnAction(event -> {
               contr.writeUserSettings(choiceBox);
               primaryStage.close();
           });
           choiceBox.setItems(digits);
           SingleSelectionModel<String> ssm = choiceBox.getSelectionModel();
           choiceBox.setSelectionModel(ssm);
           choiceBox.setLayoutX(240);
           choiceBox.setLayoutY(80);
           contr.readUserSettings(choiceBox);
           rootLayout.getChildren().add(choiceBox);
           rootLayout.getChildren().add(savechangesbutton);
           Scene scene = new Scene(rootLayout);
           primaryStage.setScene(scene);

           primaryStage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }
}}

/*    private void initComponents() {
        settingsLabel.setText("Налаштування");
        exit.setText("Вихід");
        save.setText("Зберегти зміни");
        numbCountLabel.setText("Кількість цифр в числі");
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"3", "4", "5", "6"}));
        jComboBox1.setSelectedItem("4");
        exit.addActionListener(evt -> exitActionPerformed());
        save.addActionListener(evt -> saveActionPerformed());
    }

    private void screen() {
        screen.setWindowLocation(20, 20);

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setTitle("Налаштування");
        setResizable(true);
        try {
            setIconImage(ImageIO.read(new File("src/resources/icon.png")));
        } catch (IOException exc) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, exc);
        }
        setBounds(screen.getLocationX(), screen.getLocationY(), screen.getWidth(), screen.getHeight());
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(true);


    }

    private void exitActionPerformed() {
        setVisible(false);

    }

    private void saveActionPerformed() {
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
            Properties props = new Properties();
            props.setProperty(numbCount, Objects.requireNonNull(getjComboBox1().getSelectedItem()).toString());
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
}*/
