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
import utils.GeneratorNumber;

import java.io.File;
import java.net.URL;

public class AgainstCompTest extends ApplicationTest {
    private GeneratorNumber gen = new GeneratorNumber();
    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/resources/fxml/AgainstComp.fxml").toURI().toURL();
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
    public void testTextFieldInput () {
       clickOn("#textfield");
        write("1234");
        clickOn("#inputbutton");
    }
    @Test
    public void testNewGameClick () {
        clickOn("#newgamebutton");
    }
    @Test
    public void testCapitulateClick ()  {
        clickOn("#capitulatebutton");
        press(KeyCode.SPACE);


    }
    @Test
    public void testBackClick () {
        clickOn("#backbutton");
    }
    @Test
    public void testEmptyFieldInput ()  {
        clickOn("#inputbutton");
        press(KeyCode.SPACE);

    }
    @Test
    public void testLargeNumberFieldInput ()  {
        clickOn("#textfield");
            write("123456789");
       clickOn("#inputbutton");
        press(KeyCode.SPACE);
    }
    @Test
    public void testStringFieldInput () {
        clickOn("#textfield");
            write("Hello");
        clickOn("#inputbutton");
        press(KeyCode.SPACE);


    }
    @Test
    public void testSameNumbFieldInput () {
        clickOn("#textfield");
            write("1234");
            clickOn("#inputbutton");
        clickOn("#textfield");
            write("1234");
          clickOn("#inputbutton");
        press(KeyCode.SPACE);

    }
    @Test
    public void testNumbDupesFieldInput () {
        clickOn("#textfield");
        write("1233");
        clickOn("#inputbutton");
        press(KeyCode.SPACE);

    }
    @Test
    public void testGameComplete(){
        gen.setDigits(4);
        gen.getNumber();
        clickOn("#textfield");
        write("1234");
        clickOn("#inputbutton");
        clickOn("#textfield");
        write((Integer.toString(gen.getGeneratedNumber())));
        clickOn("#inputbutton");
        press(KeyCode.SPACE);
    }


}
