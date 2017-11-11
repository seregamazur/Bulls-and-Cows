package logics;

import view.MainMenu;

import java.awt.*;

public class Controll {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu();
            }
    });
}}
