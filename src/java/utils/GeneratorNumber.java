package utils;

import java.io.*;
import java.util.Properties;
import java.util.Random;

public class GeneratorNumber implements Serializable {
    private static final long serialVersionUID = 4405172041950251804L;

    private int generatedNumber;
    private int digits;

    public int getNumber() {
        int digit = digits;
        if (digit == 3 || digit == 4 || digit == 5 || digit == 6) {
            while (!CheckerNumber.hasNoDupes(generatedNumber = new Random().nextInt((int) (9 * (Math.pow(10, digit - 1.)))) + (int) Math.pow(10, digit - 1.))) {
                //generating number without same numb
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
        } catch (IOException ex) { java.util.logging.Logger.getLogger(GeneratorNumber.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);}
        setDigits(Integer.parseInt(props.getProperty("DigitsCount")));
    }

    public void setDigits(int getdigits) {
        this.digits = getdigits;
    }

    public int getDigits() {
        return digits;
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }


}
