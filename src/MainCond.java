import java.util.InputMismatchException;
import java.util.Scanner;


public class MainCond {
    public void cond(String numbStr){
    boolean guessed = false;
    Scanner input = new Scanner(System.in);
    int guesses = 0;
        do{
        int bullcount = 0;
        int cowcount = 0;
        System.out.println("Введіть ваше 4-х значне число:");
        int guess;
        try{
            guess = input.nextInt();
            if(Generate_numb.hasDupes(guess) || guess < 1000) continue;
        }catch(InputMismatchException e){
            continue;
        }
        guesses++;
        String guessStr = guess + "";
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
