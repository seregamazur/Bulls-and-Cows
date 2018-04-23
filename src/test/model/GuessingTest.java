package model;

import org.junit.Test;
import utils.GeneratorNumber;

import static org.junit.Assert.assertEquals;

public class GuessingTest {
    private Guessing guessing = new Guessing();
    GeneratorNumber gen = new GeneratorNumber();
    InputGetter getter = new InputGetter();
    @Test
    public void testCheck() {
        gen.read();
        gen.getNumber();
        getter.setInputNumb(gen.getGeneratedNumber());
        guessing.check(gen, getter);
        assertEquals(Guessing.GenerateStatus.FINISHED, guessing.getGenerateStatus());
        assertEquals(1, guessing.getNumbers().size());
        assertEquals(1, guessing.getUsageNumbers().size());
        assertEquals(1, guessing.getGuesses());
        assertEquals(gen.getGeneratedNumber(), getter.getInputNumb());
    }
}

