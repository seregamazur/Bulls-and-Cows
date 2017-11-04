package logics;

import view.Settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
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
        Properties props = new Properties();
        InputStream input = null;

        try {
            File f = new File("settings.ini");
            input = new FileInputStream(f);
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int digit = Integer.parseInt(props.getProperty("DigitsCount"));
         cond.setSize(digit);
        Random gen = new Random();
        if (digit == 3) {
            while (hasDupes(numb = gen.nextInt(900) + 100)) {
                ;
            }
        } else if (digit == 4) {
            while (hasDupes(numb = gen.nextInt(9000) + 1000)) {
                ;
            }
        } else if (digit == 5) {
            while (hasDupes(numb = gen.nextInt(90000) + 10000)) {
                ;
            }
        } else if (digit == 6) {
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

