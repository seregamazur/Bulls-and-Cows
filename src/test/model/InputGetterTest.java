package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputGetterTest {
    @Test(expected = IllegalStateException.class)
    public void testIllegalStateException() {
        new InputGetter();
    }

    @Test
    public void testSetGetNumber() {
        InputGetter.setInputNumber(12345);
        assertEquals(12345, InputGetter.getInputNumber());
    }

    @Test
    public void testSetGetNumb() {
        InputGetter.setInputNumb(12345);
        assertEquals(12345, InputGetter.getInputNumb());
    }
}
