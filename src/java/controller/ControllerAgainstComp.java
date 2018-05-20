package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Guessing;
import model.InputGetter;
import model.Number;
import utils.CheckerNumber;
import utils.GeneratorNumber;
import view.MainMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAgainstComp implements Initializable {
    private final GeneratorNumber gen = new GeneratorNumber();
    private final Guessing guessing = new Guessing();
    private ObservableList<Number> data =
            FXCollections.observableArrayList();
    @FXML
    private javafx.scene.control.Button backbutton;
    @FXML
    private javafx.scene.control.Button inputbutton;
    @FXML
    private javafx.scene.control.Button capitulatebutton;
    @FXML
    private TableColumn<Object, Object> numbercolumn;
    @FXML
    private TableColumn<Object, Object> bullcolumn;
    @FXML
    private TableColumn<Object, Object> cowcolumn;
    @FXML
    private javafx.scene.control.TextField textfield;
    @FXML
    private TableView<Number> table;
    @FXML
    private TableColumn<Number, String> guesscolumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gen.read();
        gen.getNumber();
        setKeyListener(textfield);
    }

    @FXML
    private void backMenu() throws Exception {
        Stage stage = (Stage) backbutton.getScene().getWindow();
        stage.close();
        MainMenu mainMenu = new MainMenu();
        mainMenu.start(new Stage());
    }

    @FXML
    private void input() {
        if (textfield.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вами не було введено число.", ButtonType.OK);
            alert.showAndWait();
            return;
        } else {
            if (guessing.getUsageNumbers().contains(Integer.parseInt(textfield.getText()))) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ви вже вводили дане число.", ButtonType.OK);
                alert.showAndWait();
                textfield.setText("");
                return;
            } else {
                InputGetter.setInputNumb(Integer.parseInt(textfield.getText()));
            }
        }
        if (Integer.toString(InputGetter.getInputNumb()).length() != gen.getDigits() || !CheckerNumber.hasNoDupes(InputGetter.getInputNumb())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Потрiбно ввести число без повторiв цифр у ньому \n та правильної кiлькостi.\nКількість цифр у числі правильного формату: " + gen.getDigits(), ButtonType.OK);
            alert.showAndWait();
        } else {
            guessing.check(gen);
            data.add(new Number(InputGetter.getInputNumb(), gen.getGeneratedNumber()));
            guesscolumn.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(table.getItems().
                    indexOf(p.getValue()) + 1 + ""));
            numbercolumn.setCellValueFactory(
                    new PropertyValueFactory<>("ourDigit"));
            bullcolumn.setCellValueFactory(
                    new PropertyValueFactory<>("ourBulls"));
            cowcolumn.setCellValueFactory(
                    new PropertyValueFactory<>("ourCows"));
            table.setItems(data);
            textfield.setText("");

        }

        if (guessing.getGenerateStatus() == Guessing.GenerateStatus.FINISHED) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ви відгадали число за  " + table.getItems().size() + " спроб!", ButtonType.OK);
            alert.showAndWait();
            inputbutton.setDisable(true);
            textfield.setDisable(true);
            capitulatebutton.setDisable(true);
        }

    }

    @FXML
    private void newGame() {
        textfield.setText("");
        textfield.setDisable(false);
        inputbutton.setDisable(false);
        capitulatebutton.setDisable(false);
        guessing.getUsageNumbers().clear();
        table.getItems().clear();
        gen.getNumber();
    }

    private void setKeyListener(TextField text) {
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                text.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    @FXML
    private void capitulate() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ви програли!\nПравильним числом було:" + gen.getGeneratedNumber(), ButtonType.OK);
        alert.showAndWait();
        textfield.setText("");
        table.getItems().clear();
        guessing.getUsageNumbers().clear();
        gen.getNumber();
    }

}
