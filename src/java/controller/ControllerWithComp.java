package controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ComputerGenerator;
import model.InputGetter;
import model.Number;
import utils.CheckerNumber;
import utils.GeneratorNumber;
import view.MainMenu;

import javax.swing.*;

import static model.ComputerGenerator.GenerateStatus.FINISHED;
import static model.ComputerGenerator.GenerateStatus.GENERATING;

public class ControllerWithComp {
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
        setKeyListener(textfield);
        if (textfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Вами не було введено число.");
        } else {
            InputGetter.setInputNumber(Integer.parseInt(textfield.getText()));
            if (Integer.toString(InputGetter.getInputNumber()).length() != gen.getDigits() || (!CheckerNumber.hasNoDupes(InputGetter.getInputNumber()))) {
                JOptionPane.showMessageDialog(null,
                        "Ви задали число неправильно формату.\nКількість цифр в числі правильного формату: " + gen.getDigits());
            } else {
                while (computerGenerator.getGenerateStatus() != FINISHED) {
                    computerGenerator.generateAndCheck(gen);
                    data.add(new Number(computerGenerator.getMoves().getLast().getDigit(), InputGetter.getInputNumber()));
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
                JOptionPane.showMessageDialog(null, "Комп'ютер відгадав ваше число за " + computerGenerator.getMoves().size() + " спроб!");
                startbutton.setDisable(true);
                textfield.setDisable(true);
                computerGenerator.getMoves().clear();
                computerGenerator.getNumbers().clear();
                computerGenerator.setGenerateStatus(GENERATING);
            }
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
