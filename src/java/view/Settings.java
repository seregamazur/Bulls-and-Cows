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

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class Settings implements Serializable {
    private static final long serialVersionUID = 2405172041950251803L;

    public void initSettings() {
        try {
            final ControllerSettings contr = new ControllerSettings();
            Pane rootLayout;
            Stage primaryStage = new Stage();
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setTitle("Змiнити налаштування");
            URL url = new File("src/resources/fxml/Settings.fxml").toURI().toURL();
            rootLayout = FXMLLoader.load(url);
            ObservableList<String> digits = FXCollections.observableArrayList("3", "4", "5", "6");
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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

    }
}
