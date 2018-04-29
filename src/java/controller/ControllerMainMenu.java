package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import view.AgainstComp;
import view.Settings;
import view.WithComp;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainMenu implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private void withCompStart(){
        closeButton();
        WithComp withComp = new WithComp();
        withComp.initWithComp();
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
        AgainstComp againstComp = new AgainstComp();
        againstComp.initAgainstComp();
    }
    @FXML
    private void settingsStart(){
        Settings settings = new Settings();
        settings.initSettings();
    }
}
