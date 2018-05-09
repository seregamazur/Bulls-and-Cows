package controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import view.AgainstComp;
import view.Mode;
import view.Settings;
import view.WithComp;

public class ControllerMainMenu {

    @FXML
    private void withCompStart() {
        closeButton();
        closeButton();
        Mode modeWith = new Mode("WithComp");
//        WithComp withComp = new WithComp();
//        withComp.initWithComp();
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
        Mode modeAgainst = new Mode("AgainstComp");
//        AgainstComp againstComp = new AgainstComp();
//        againstComp.initAgainstComp();
    }

    @FXML
    private void settingsStart() {
        Settings settings = new Settings();
        settings.initSettings();
    }
}
