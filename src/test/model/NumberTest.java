package model;

import org.junit.Test;

public class NumberTest {
    Number number = new Number(12345, 54318);

    @Test
    public void testGetDigit() {
        number.getDigit();
    }
}
