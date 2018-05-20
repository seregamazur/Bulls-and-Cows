package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ComputerGenerator;
import model.InputGetter;
import model.Number;
import utils.CheckerNumber;
import utils.GeneratorNumber;
import view.MainMenu;

import java.net.URL;
import java.util.ResourceBundle;

import static model.ComputerGenerator.GenerateStatus.FINISHED;
import static model.ComputerGenerator.GenerateStatus.GENERATING;

public class ControllerWithComp implements Initializable {
    private final ComputerGenerator computerGenerator = new ComputerGenerator();
    private ObservableList<Number> data =
            FXCollections.observableArrayList();
    private final GeneratorNumber gen = new GeneratorNumber();
    @FXML
    private javafx.scene.control.Button backbutton;
    @FXML
    private javafx.scene.control.Button startbutton;
    @FXML
    private javafx.scene.control.TextField textfield;
    @FXML
    private TableView<Number> table;
    @FXML
    private TableColumn<Number, String> guesscolumn;
    @FXML
    private TableColumn<Object, Object> numbercolumn;
    @FXML
    private TableColumn<Object, Object> bullcolumn;
    @FXML
    private TableColumn<Object, Object> cowcolumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    private void startGame() {
        gen.read();
        if (textfield.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Вами не було введено число.", ButtonType.OK);
            alert.showAndWait();
            return;
        } else {
            InputGetter.setInputNumber(Integer.parseInt(textfield.getText()));
        }
        if ((Integer.toString(InputGetter.getInputNumber()).length() != gen.getDigits())
                || (!CheckerNumber.hasNoDupes(InputGetter.getInputNumber()))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Число потрiбно загадати без повторiв у ньому \n та правильної кiлькостi.\nКількість цифр у числі правильного формату: " + gen.getDigits(), ButtonType.OK);
            alert.showAndWait();
        } else {
            while (computerGenerator.getGenerateStatus() != FINISHED) {
                computerGenerator.generateAndCheck(gen);
                if ((computerGenerator.getMoves().getLast().getBullCount() == 0) &&
                        (computerGenerator.getMoves().getLast().getCowCount() == 0)) {/*missing turn*/} else {
                    data.add(new Number(computerGenerator.getMoves().getLast().getDigit(),
                            InputGetter.getInputNumber()));
                }
            }
            table.setItems(data);
        }

        if (computerGenerator.getGenerateStatus() == FINISHED) {
            guesscolumn.setCellValueFactory(p -> new ReadOnlyObjectWrapper<>(table.getItems().
                    indexOf(p.getValue()) + 1 + ""));
            numbercolumn.setCellValueFactory(
                    new PropertyValueFactory<>("ourDigit"));
            bullcolumn.setCellValueFactory(
                    new PropertyValueFactory<>("ourBulls"));
            cowcolumn.setCellValueFactory(
                    new PropertyValueFactory<>("ourCows"));
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Комп'ютер відгадав ваше число за " + computerGenerator.getMoves().size() + " спроб!", ButtonType.OK);
            alert.showAndWait();
            startbutton.setDisable(true);
            textfield.setDisable(true);
            computerGenerator.getMoves().clear();
            computerGenerator.getNumbers().clear();
            computerGenerator.setGenerateStatus(GENERATING);
        }
    }

    @FXML
    private void newGame() {
        table.getItems().clear();
        textfield.setText("");
        textfield.setDisable(false);
        startbutton.setDisable(false);
        computerGenerator.getMoves().clear();
        computerGenerator.getNumbers().clear();
    }

    private void setKeyListener(TextField text) {
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                text.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });


    }


}
