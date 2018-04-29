package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import view.Settings;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class ControllerSettings {

    @FXML
    private javafx.scene.control.Button cancelbutton;

    @FXML
    private void cancelSave() {
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();

    }

    public void writeUserSettings(ChoiceBox<String> choiceBox) {
        try {
            String numbCount = "DigitsCount";
            Properties props = new Properties();
            props.setProperty(numbCount, Objects.requireNonNull(choiceBox.getSelectionModel().getSelectedItem()));
            File f = new File("settings.properties");
            OutputStream out = new FileOutputStream(f);
            props.store(out, null);
            out.close();
        } catch (Exception io) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, io);
        }
    }

    public void readUserSettings(ChoiceBox<String> choiceBox) {
        Properties props = new Properties();
        InputStream input;
        try {
            File f = new File("settings.properties");
            input = new FileInputStream(f);
            props.load(input);
            choiceBox.getSelectionModel().select(props.getProperty("DigitsCount"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
