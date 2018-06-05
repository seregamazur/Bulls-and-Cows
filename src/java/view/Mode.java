package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.logging.Logger;

public class Mode implements Serializable {
    private static final long serialVersionUID = 2405172041950251802L;

    public Mode(String modeName){
        try {
            Pane rootLayout;
            Stage primaryStage = new Stage();
            URL url = new File("src/resources/fxml/"+ modeName +".fxml").toURI().toURL();
            rootLayout = FXMLLoader.load(url);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            if(modeName.startsWith("A")){
            primaryStage.setTitle("Вiдгадати число");}else primaryStage.setTitle("Загадати число");
            primaryStage.show();
        } catch (IOException e) {
            Logger.getLogger(Mode.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }


    }

}
