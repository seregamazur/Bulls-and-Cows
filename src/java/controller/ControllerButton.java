package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import view.Settings;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;

public class ControllerButton implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    private void withCompStart(){
        closeButton();
        System.out.println("WithComp");
    }
    @FXML private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButton(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void againstCompStart(){
        closeButton();
        System.out.println("AgainstComp");
    }
    @FXML
    private void settingsStart(){
        Settings settings = new Settings();
        settings.initSettings();
        System.out.println("Settings");
    }
    @FXML private javafx.scene.control.Button cancelbutton;
    @FXML
    private void cancelSave(){
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();

    }
    @FXML private ChoiceBox<String> choicebox;
    @FXML private javafx.scene.control.Button savebutton;
    @FXML
    private void writeUserSettings(){
     try {
        String numbCount = "DigitsCount";
        Properties props = new Properties();
        props.setProperty(numbCount, Objects.requireNonNull(choicebox.getSelectionModel().getSelectedItem()));
        File f = new File("settings.properties");
        OutputStream out = new FileOutputStream(f);
        props.store(out, null);
        out.close();
    } catch (Exception io) {
        java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, io);
    }
    Stage stage = (Stage) savebutton.getScene().getWindow();
    stage.close();}

    public void readUserSettings() {
        Properties props = new Properties();
        InputStream input;
        try {
            File f = new File("settings.properties");
            input = new FileInputStream(f);
            props.load(input);
            choicebox.getSelectionModel().select(props.getProperty("DigitsCount"));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
