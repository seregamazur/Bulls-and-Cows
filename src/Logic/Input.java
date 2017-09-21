package Logic;

import Interface.ErrorType;
import Interface.Reader;
import java.util.InputMismatchException;
public class Input {
public void Incompare() {
    ErrorType er = new ErrorType();
    Reader r = new Reader(null);

    try{
        int  guess = Integer.parseInt(r.guessStr);
    if(GenerateNumb.hasDupes(guess) || guess < 1000) { }
}catch(InputMismatchException | NumberFormatException e) {
       er.Error();
    }




}
}
