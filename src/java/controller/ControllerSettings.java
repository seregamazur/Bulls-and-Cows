package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import view.Settings;

import java.io.*;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerSettings {
    private static final String DEFAULT_PROPERTY = "4";
    private static Properties props = new Properties();
    public static final String NUMBCOUNT = "DigitsCount";
    public static final String FILE_PROPERTIES = "settings.properties";


    @FXML
    private javafx.scene.control.Button cancelbutton;

    @FXML
    private void cancelSave() {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();

    }

    public void writeUserSettings(ChoiceBox<String> choiceBox) {
        try {
            props.setProperty(NUMBCOUNT, Objects.requireNonNull(choiceBox.getSelectionModel().getSelectedItem()));
            File f = new File(FILE_PROPERTIES);
            OutputStream out = new FileOutputStream(f);
            props.store(out, null);
            out.close();
        } catch (Exception io) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, io);
        }
    }

    public void readUserSettings(ChoiceBox<String> choiceBox) {
        InputStream input;
        try {
            File f = new File(FILE_PROPERTIES);
            if (!f.exists()) {
                defaultFileProperties();
            }
            input = new FileInputStream(f);
            props.load(input);
            choiceBox.getSelectionModel().select(props.getProperty(NUMBCOUNT));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public static void defaultFileProperties() {
        try {
            File f = new File(FILE_PROPERTIES);
            if(f.createNewFile()){
                props.setProperty(NUMBCOUNT, DEFAULT_PROPERTY);
                OutputStream out = new FileOutputStream(f);
                props.store(out, null);
                out.close();
            } else Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, "cannot create file property");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
