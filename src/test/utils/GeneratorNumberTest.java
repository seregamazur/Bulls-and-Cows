package utils;

import controller.ControllerSettings;
import org.junit.Test;

import java.io.File;

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
    @Test
    public void testNoFile(){
        File f = new File(ControllerSettings.FILE_PROPERTIES);
        if(f.delete()){gen.read();}
    }
  

}

