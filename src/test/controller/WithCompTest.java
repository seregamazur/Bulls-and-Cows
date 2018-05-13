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

public class WithCompTest extends ApplicationTest {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/resources/fxml/WithComp.fxml").toURI().toURL();
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
    public void testBackClick () {
        clickOn("#backbutton");

    }
    @Test
    public void testTextFieldInput () {
        clickOn("#textfield");
        write("1234");
        press(KeyCode.ENTER);
        clickOn("#startbutton");


    } @Test
    public void testNewGameClick () {
        clickOn("#newgamebutton");

    }


}
