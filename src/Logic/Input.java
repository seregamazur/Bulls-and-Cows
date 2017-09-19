package Logic;


import Interface.Reader;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
public void Incompare() {
    Scanner input = new Scanner(System.in);
    Reader r = new Reader("Слава україні");
    int guess;
    boolean right = false;
    do{
    try{
    guess = input.nextInt();
    if(GenerateNumb.hasDupes(guess) || guess < 1000) continue;right = false;
}catch(InputMismatchException e){
      //okno
    continue;
}



}while(!right);
}}
