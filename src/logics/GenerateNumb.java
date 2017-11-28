package logics;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class GenerateNumb {

    private String NumbStr;
    private Random gen = new Random();
    private int numb;
    private int digit;

    public String getNumbStr() {
        return NumbStr;
    }

    public void setNumbStr(String numbStr) {
        NumbStr = numbStr;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }


    public void getNumber() {
        if (digit == 3 || digit == 4 || digit == 5 || digit == 6) {
            while (hasDupes(numb = gen.nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1))) {
                ;
            }
        }
        setNumbStr(numb + "");
    }

    public void read() {
        Properties props = new Properties();
        InputStream input = null;
        try {
            File f = new File("settings.properties");
            input = new FileInputStream(f);
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setDigit(Integer.parseInt(props.getProperty("DigitsCount")));
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

