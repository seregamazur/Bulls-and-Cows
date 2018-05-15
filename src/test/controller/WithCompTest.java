package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WithCompTest extends ApplicationTest {
    @Override
    public void start(Stage stage) {
        try {


        URL url = new File("src/resources/fxml/WithComp.fxml").toURI().toURL();
        Parent mainNode = FXMLLoader.load(url);
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
        } catch (IOException e) {
            java.util.logging.Logger.getLogger(WithCompTest.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }

    }
    @After
    public void tearDown () throws Exception {
        FxToolkit.hideStage();
    }
    @Test
    public void testBackClick () {
        clickOn("#backbutton");

    }
    @Test(expected = NumberFormatException.class)
    public void testTextFieldInput () {
            clickOn("#textfield");
            write("1234");
        clickOn("#startbutton");

    }
    @Test(expected = NumberFormatException.class)
    public void testLargeNumberFieldInput () {
       clickOn("#textfield");
            write("123456789");
        clickOn("#startbutton");
    }
    @Test(expected = NumberFormatException.class)
    public void testEmptyFieldInput () {
        clickOn("#startbutton");
        }
    @Test
    public void testNewGameClick () {
        clickOn("#newgamebutton");

    }
    @Test(expected = NumberFormatException.class)
    public void testStringFieldInput () {
        clickOn("#textfield");
            write("Hello");
    clickOn("#startbutton");
    }


}
