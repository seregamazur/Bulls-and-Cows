import java.util.Random;
import java.util.Scanner;

/**
 * Created by IIDEMONII on 08.09.2017.
 */
public class Logic {
    Logic(){
            Random random = new Random();
            int rage = 9999;
            int  generator = 1000 + random.nextInt(rage - 1000);
        System.out.println(Integer.toString(generator));
        }

    public static void main(String[] args) {
        Logic Log = new Logic();
        boolean yes;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number:");
        int guess = scan.nextInt();
        Integer.toString(guess);
        System.out.println(guess.equals(generator));






    }



    }
