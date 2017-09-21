package Logic;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainCond {
public int guesses = 0;
public  String guessStr;

public void cond(String numbStr){
    Input in = new Input();
boolean guessed = false;
    do{
    int bullcount = 0;
    int cowcount = 0;

    for(int i= 0;i < 4;i++){
        if(guessStr.charAt(i) == numbStr.charAt(i)){
            bullcount++;
        }else if(numbStr.contains(guessStr.charAt(i)+"")){
            cowcount++;
        }
    }
    if(bullcount == 4){
        guessed = true;
    }else{
        System.out.println(cowcount+" Корів і "+bullcount+" биків");
    }
}while(!guessed);
    System.out.println("Ви виграли за "+guesses+" спроб.");
}

}
