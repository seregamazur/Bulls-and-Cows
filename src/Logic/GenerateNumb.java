package Logic;
import java.util.Random;
public class GenerateNumb {
    private int numb;

    public String getNumbStr() {
        return NumbStr;
    }

    public void setNumbStr(String numbStr) {
        NumbStr = numbStr;
    }
    private String NumbStr;
    public  int getNumber() {
Random gen = new Random();
while(hasDupes(numb = gen.nextInt(9000) + 1000)) {;}
setNumbStr(numb + "");
return numb;
}
    public   boolean hasDupes(int num) {
for(boolean[] digs = new boolean[10]; num > 0; num /= 10) {
if(digs[num % 10]) {
return true;
}
digs[num % 10] = true;
}
return false;
}
}

