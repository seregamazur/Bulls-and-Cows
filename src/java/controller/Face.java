package java.controller;


import java.view.AgainstComp;
import java.view.Settings;
import java.view.WithComp;

public class Face {
    public static void startAgainst() {
        new AgainstComp();
    }

    public static void startSettings() {
        new Settings();
    }

    public static void startWith() {
        new WithComp();
    }


}
