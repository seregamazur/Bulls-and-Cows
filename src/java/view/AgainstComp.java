package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class AgainstComp implements Serializable {
    private static final long serialVersionUID = 2405172041950251805L;

    public void initAgainstComp() {
        try {
            Pane rootLayout;
            Stage primaryStage = new Stage();
            URL url = new File("src/resources/fxml/AgainstComp.fxml").toURI().toURL();
            rootLayout = FXMLLoader.load(url);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Вiдгадати число");
            primaryStage.show();
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(AgainstComp.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

    }
}