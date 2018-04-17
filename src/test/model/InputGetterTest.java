package model;

import org.junit.*;
public class InputGetterTest {
   private static  InputGetter inputGetter = new InputGetter();
    @Test
    public void setInputNumb(){
        inputGetter.setInputNumb(1234);
    }
    @Test
    public void setInputNumber(){
        inputGetter.setInputNumber(3265);
    }
    @Test
    public void getInputNumber(){
        inputGetter.getInputNumber();
    }
    @Test
    public void getInputNumb(){
        inputGetter.getInputNumb();
    }
}
