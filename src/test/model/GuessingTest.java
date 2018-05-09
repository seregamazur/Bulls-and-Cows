package model;

import org.junit.Test;
import utils.GeneratorNumber;

import static org.junit.Assert.assertEquals;

public class GuessingTest {
    private Guessing guessing = new Guessing();
    private final GeneratorNumber gen = new GeneratorNumber();
    @Test
    public void testCheck() {
        gen.setDigits(5);
        gen.getNumber();
        InputGetter.setInputNumb(12345);
        guessing.check(gen);
        assertEquals(Guessing.GenerateStatus.GUESSING, guessing.getGenerateStatus());
        InputGetter.setInputNumb(gen.getGeneratedNumber());
        guessing.check(gen);
        assertEquals(Guessing.GenerateStatus.FINISHED, guessing.getGenerateStatus());
        assertEquals(2, guessing.getNumbers().size());
        assertEquals(2, guessing.getUsageNumbers().size());
        assertEquals(2, guessing.getGuesses());
        assertEquals(gen.getGeneratedNumber(), InputGetter.getInputNumb());
    }
}

