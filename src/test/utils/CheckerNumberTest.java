package utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CheckerNumberTest {
    @Test(expected = IllegalStateException.class)
    public void testIllegalStateException() {
        new CheckerNumber();
    }

    @Test
    public void notRightType() {
        assertFalse(CheckerNumber.hasNoDupes(4444));
    }

    @Test
    public void rightType() {
        assertTrue(CheckerNumber.hasNoDupes(1234));
    }


}
