package Logic;

import Interface.ErrorType;
import Interface.Reader;
import java.util.InputMismatchException;
public class Input {

public void Incompare() {
    Reader r2 = new Reader(null);
    ErrorType er = new ErrorType();
    MainCond cond1 = new MainCond();
    try{
        int  guess = Integer.parseInt(r2.guessStr);
    if(GenerateNumb.hasDupes(guess) || guess < 1000) { er.Error();}
    else {  cond1.cond();}
}catch(InputMismatchException | NumberFormatException e) {
    }
}
}
