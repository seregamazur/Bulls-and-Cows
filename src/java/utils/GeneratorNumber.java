package utils;

import controller.ControllerSettings;

import java.io.*;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        InputStream input;
        try {
            File f = new File(ControllerSettings.FILE_PROPERTIES);
            if (!f.exists()) {
                ControllerSettings.defaultFileProperties();
            }
            input = new FileInputStream(f);
            props.load(input);
        } catch (IOException ex) {
            Logger.getLogger(GeneratorNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDigits(Integer.parseInt(props.getProperty(ControllerSettings.NUMBCOUNT)));
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
