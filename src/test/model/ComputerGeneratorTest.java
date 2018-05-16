package model;

import org.junit.Test;
import utils.GeneratorNumber;

import static org.junit.Assert.assertEquals;


public class ComputerGeneratorTest {
    private model.ComputerGenerator generator = new ComputerGenerator();
    private utils.GeneratorNumber gen = new GeneratorNumber();

    @Test
    public void testGenerateAndCheck() {
        InputGetter.setInputNumber(12345);
        gen.setDigits(5);

        while (generator.getGenerateStatus() != ComputerGenerator.GenerateStatus.FINISHED) {
            generator.generateAndCheck(gen);
        }
        generator.getNumbers();

        assertEquals(12345, generator.getMoves().getLast().getDigit());
    }
    @Test
    public void testInterruptedGenerateAndCheck(){
        InputGetter.setInputNumber(96547);
        gen.setDigits(5);
        generator.setGenerateStatus(ComputerGenerator.GenerateStatus.GENERATING);
        while (generator.getGenerateStatus() != ComputerGenerator.GenerateStatus.FINISHED) {
            generator.generateAndCheck(gen);
        }
        generator.generateAndCheck(gen);
        generator.getNumbers();
        assertEquals(96547, generator.getMoves().getLast().getDigit());
    }

}
