package controller;

import view.MainMenu;

import java.awt.*;

public class Controller {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        EventQueue.invokeLater(MainMenu::new);
    }
}
