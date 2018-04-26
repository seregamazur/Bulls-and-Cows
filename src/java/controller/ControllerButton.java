package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
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
        System.out.println("Settings");
    }
}
