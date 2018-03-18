package utils;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.CheckerNumber;



public class CheckerNumberTest {
   CheckerNumber checkerNumber = new CheckerNumber();
    @Test
    public void notRightType(){
        assertFalse(checkerNumber.hasNoDupes(4444));
    }
    @Test
    public void rightType(){
        assertTrue(checkerNumber.hasNoDupes(1234));
    }


}
