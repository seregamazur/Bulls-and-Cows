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

    public int getNumber(Condition cond) {

        Random gen = new Random();
        if (cond.getSize() == 3) {
            while (hasDupes(numb = gen.nextInt(900) + 100)) {
                ;
            }
        } else if (cond.getSize() == 4) {
            while (hasDupes(numb = gen.nextInt(9000) + 1000)) {
                ;
            }
        } else if (cond.getSize() == 5) {
            while (hasDupes(numb = gen.nextInt(90000) + 10000)) {
                ;
            }
        } else if (cond.getSize() == 6) {
            while (hasDupes(numb = gen.nextInt(900000) + 100000)) {
                ;
            }
        }
        setNumbStr(numb + "");
        return numb;
    }

    public boolean hasDupes(int num) {
        for (boolean[] digs = new boolean[10]; num > 0; num /= 10) {
            if (digs[num % 10]) {
                return true;
            }
            digs[num % 10] = true;
        }
        return false;
    }
}

