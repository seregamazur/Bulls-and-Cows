package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import view.Settings;

import java.io.File;
import java.net.URL;

public class SettingsTest extends ApplicationTest {
    private Settings settings = new Settings();

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/resources/fxml/Settings.fxml").toURI().toURL();
        Parent mainNode = FXMLLoader.load(url);
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
    }

    @Test
    public void initSettings() {
        new Thread(() -> settings.initSettings());
    }

    @Test
    public void testCancel() {
        clickOn("#cancelbutton");
    }


}
