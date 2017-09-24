package Logic;

import Interface.ErrorType;
import Interface.Reader;
import java.util.InputMismatchException;
public class Input {

public void Incompare() {
    Reader r2 = new Reader("pav");
    ErrorType er = new ErrorType();
    GenerateNumb gen1 = new GenerateNumb();
    MainCond cond1 = new MainCond();
    try{
        int  guess = Integer.parseInt(r2.guessStr);
    if(gen1.hasDupes(guess) || guess < 1000) { er.Error();}
    else {  cond1.cond();}
}catch(InputMismatchException | NumberFormatException e) {
    }
}
}
