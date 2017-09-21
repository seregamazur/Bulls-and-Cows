package Logic;
import Interface.Reader;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MainCond {
public int guesses = 0;
Reader r = new Reader(null);

public void cond(String numbStr){
    boolean guessed = false;
    int bullcount = 0;
    int cowcount = 0;
    for(int i= 0;i < 4;i++){
        if(r.guessStr.charAt(i) == numbStr.charAt(i)){
            bullcount++;
        }else if(numbStr.contains(r.guessStr.charAt(i)+"")){
            cowcount++;
        }
    }
    if(bullcount == 4){
        guessed = true;
    }else{
        System.out.println(cowcount+" Корів і "+bullcount+" биків");

}while(!guessed);
    System.out.println("Ви виграли за "+guesses+" спроб.");
}

}
