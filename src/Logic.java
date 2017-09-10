import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by IIDEMONII on 08.09.2017.
 */
public class Logic {


    public static void main(String[] args) {
        int number;
        String guess  ;
        Scanner scan = new Scanner(System.in);
        boolean yes;
        Random generator;
        int[] array = new int[4];
        generator = new Random();
        for(int i=0; i<4; i++)
        {
            number = generator.nextInt( 10 );
            yes=true;
            for(int j=0; j<=i; j++)
            {
                if(number==array[j])
                    yes=false;

            }
            if(yes){
                array[i]=number;
                System.out.print(number);
            }else{
                i--;
            }

        }
        guess = scan.next();
        String strArr[] = guess.split("");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        int Bullcount = 0, cowcount = 0;
        for(int i = 0;i<numArr.length;i++){
            if(numArr[i] == array[i]) Bullcount++;
        }
        for(int i = 0;i<numArr.length;i++){
            for(int j = 0;j< numArr.length;j++){
                if(numArr[i] == array[j]) cowcount++;
            }
        }

        System.out.print("Кількість биків:" + Bullcount + "Кількість корів:" + cowcount );

        }



    }




