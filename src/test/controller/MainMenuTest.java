package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;
import java.net.URL;

public class MainMenuTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/resources/fxml/MainMenu.fxml").toURI().toURL();
        Parent mainNode = FXMLLoader.load(url);
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
    }
    @Test
    public void testAgainstClick () {
        clickOn("#againstcompbutton");
    }
    @Test
    public void testWithClick () {
        clickOn("#withcompbutton");
    }
    @Test
    public void testSettingsClick () {
        clickOn("#settingsbutton");
        press(KeyCode.SPACE);
    }


}

