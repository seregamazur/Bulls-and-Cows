import org.junit.*;
import model.InputGetter;
public class InputGetterTest {
    InputGetter inputGetter = new InputGetter();
    @Test
    public void inputNumb(){
        inputGetter.setInputNumb(1234);
    }

    @Test
    public void getInputNumb(){
        inputGetter.getInputNumb();
    }
}
