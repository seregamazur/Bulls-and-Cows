package controller;


import view.AgainstComp;
import view.Settings;
import view.WithComp;

public class Face {
    private Face() {
        throw new IllegalStateException("Face class");
    }
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
