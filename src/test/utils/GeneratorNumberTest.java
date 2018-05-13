package utils;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratorNumberTest {
    private GeneratorNumber gen = new GeneratorNumber();


    @Test
    public void testGenerate() {
        for(int i = 0;i<10;i++){
        gen.setDigits(i);
        gen.getNumber();}
    }
    @Test
    public void testRead(){
        gen.read();
    }

}

