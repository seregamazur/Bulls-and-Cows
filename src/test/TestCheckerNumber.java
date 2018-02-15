import org.junit.Test;
import static org.junit.Assert.*;
import utils.CheckerNumber;



public class TestCheckerNumber {

    @Test
    public void rightType(){
        assertFalse(CheckerNumber.hasNoDupes(4444));
    }


}
