package utils;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.CheckerNumber;



public class CheckerNumberTest{
    @Test
    public void notRightType(){
        assertFalse(CheckerNumber.hasNoDupes(4444));
    }
    @Test
    public void rightType(){
        assertTrue(CheckerNumber.hasNoDupes(1234));
    }


}
