package utils;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GeneratorNumberTest {
    private GeneratorNumber gen = new GeneratorNumber();

    @Test
    public void testRead() {
        gen.read();
        Logger.getLogger(GeneratorNumber.class.getName()).log(Level.ALL, "");

    }

    @Test
    public void testGenerate() {
        gen.getNumber();
    }
}

