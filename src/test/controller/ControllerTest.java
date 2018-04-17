package controller;

import org.junit.Test;

public class ControllerTest {
Controller controller = new Controller();
@Test
    public void testControllerMenu(){
    String[] args = new String[0];
    Controller.menu();
    Controller.main(args);
}
}
