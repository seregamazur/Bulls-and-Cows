package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class GeneratorNumber {

    private int generatedNumber;
    private int Digits;

    public int getNumber() {
        int digit = Digits;
        if (digit == 3 || digit == 4 || digit == 5 || digit == 6) {
            while (!CheckNumber.hasNoDupes(generatedNumber = new Random().nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1))) {
                ;
            }
        }
        return generatedNumber;
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
        setDigits(Integer.parseInt(props.getProperty("DigitsCount")));
    }

    public void setDigits(int getDigits) {
        this.Digits = getDigits;
    }

    public int getDigits() {
        return Digits;
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }


}
