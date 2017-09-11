import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Logic{
    public static void main(String[] args){
        Random gen = new Random();
        int numb = 0;
        while(hasDupes(numb = (gen.nextInt(9000) + 1000)));
        System.out.println(numb);
        String numbStr = numb +"";
        boolean guessed = false;
        Scanner input = new Scanner(System.in);
        int guesses = 0;
        do{
            int bullcount = 0;
            int cowcount = 0;
            System.out.print("Введіть ваше 4-х значне число:");
            int guess;
            try{
                guess = input.nextInt();
                if(hasDupes(guess) || guess < 1000) continue;
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

    public static boolean hasDupes(int num){
        boolean[] digs = new boolean[10];
        while(num > 0){
            if(digs[num%10]) return true;
            digs[num%10] = true;
            num/= 10;
        }
        return false;
    }
}