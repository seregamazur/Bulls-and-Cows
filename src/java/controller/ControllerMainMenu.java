package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import view.Mode;
import view.Settings;

public class ControllerMainMenu {

    @FXML
    private void withCompStart() {
        closeButton();
        new Mode("WithComp");
    }

    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    private void closeButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void againstCompStart() {
        closeButton();
        new Mode("AgainstComp");

    }

    @FXML
    private void settingsStart() {
        Settings settings = new Settings();
        settings.initSettings();
    }
}
