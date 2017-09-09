import java.util.Random;
import java.util.Scanner;

/**
 * Created by IIDEMONII on 08.09.2017.
 */
public class Logic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cowsnum,bullnum,guess;
        int number;
        boolean yes;
        Random generator;
        int[] array = new int[4];
        generator = new Random();
        for(int i=0; i<4; i++)
        {
            number = generator.nextInt( 9 );
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

}}
