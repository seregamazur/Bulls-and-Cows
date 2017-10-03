package Logic;
import java.util.Random;
public class GenerateNumb {
    public static String numbStr ;
public static  void go() {
Random gen = new Random();
int numb;
while(hasDupes(numb = gen.nextInt(9000) + 1000)) {;}
    numbStr = numb + "";
{                                                       }

}
public static boolean hasDupes(int num) {
for(boolean[] digs = new boolean[10]; num > 0; num /= 10) {
if(digs[num % 10]) {
return true;
}
digs[num % 10] = true;
}
return false;
}
}

