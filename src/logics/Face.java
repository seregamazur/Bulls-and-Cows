package logics;


import view.AgainstComp;
import view.Settings;
import view.WithComp;

public class Face {
    public void start() {
        new AgainstComp();
    }

    public void start1() {
        new WithComp();
    }

    public void startSettings() {
        new Settings();
    }

}
