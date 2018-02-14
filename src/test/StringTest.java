import org.junit.Test;
import static org.junit.Assert.*;
import utils.CheckNumber;



public class StringTest {

    @Test
    public void rightType(){
        assertFalse(CheckNumber.hasNoDupes(4444));
    }


}
