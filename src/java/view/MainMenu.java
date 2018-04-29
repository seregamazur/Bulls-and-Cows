package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.Serializable;
import java.net.URL;

public class MainMenu extends Application implements Serializable {
    private static final long serialVersionUID = 2405172041950251804L;

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = new File("src/resources/fxml/MainMenu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setScene(new Scene(root, 600, 420));
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Бики та корови");
        primaryStage.getIcons().add(new Image("file:resources/images/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}