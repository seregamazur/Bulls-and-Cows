package logics;


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
    private Random gen = new Random();


    private int digit;

    public int getNumber(Condition cond) {
        Properties props = new Properties();
        InputStream input = null;
        try {
            File f = new File("settings.ini");
            input = new FileInputStream(f);
            props.load(input);
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        digit = Integer.parseInt(props.getProperty("DigitsCount"));
        cond.setSize(digit);

        if (digit == 3 ) {
            while (hasDupes(numb = gen.nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1))) {
                ;
            }
        }
        else if (digit == 4 ) {
            while (hasDupes(numb = gen.nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1))) {
                ;
            }
        } else if (digit == 5 ) {
            while (hasDupes(numb = gen.nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1))) {
                ;
            }
        } else if (digit == 6 ) {
            while (hasDupes(numb = gen.nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1))) {
                ;
            }
        }
        setNumbStr(numb + "");
        return numb;
    }

    public void read(Condition cond) {
        Properties props = new Properties();
        InputStream input = null;
        try {
            File f = new File("settings.ini");
            input = new FileInputStream(f);
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        digit = Integer.parseInt(props.getProperty("DigitsCount"));
        cond.setSize(digit);
    }

    public int getNumb(Condition cond) {
        if(digit == 3 || cond.getLuckyCount() == 0){
        while (hasDupes(numb =  gen.nextInt  ((int) (9*(Math.pow(10,digit-1)))) + (int) Math.pow(10,digit-1))) {
            ;
        }}
        else if  (digit == 3 &&  cond.getLuckyCount() == 1) {
            int n[]  = new int[4];
            for(int i = 0;i<4;i++) { n[i] =  (Integer)cond.getMyList().toArray()[i];
            System.out.println(n[i]);}
            while (hasDupes(numb =  gen.nextInt  ((int) (9*(Math.pow(10,digit-2)))) + (int) Math.pow(10,digit-2))) {
                ;
            }
            numb =+ (Integer) (cond.getMyList().toArray()[2]);
            }
//            }
//         if (digit == 4 ) {
//            while (hasDupes(numb =  gen.nextInt  ((int) (9*(Math.pow(10,digit-1)))) + (int) Math.pow(10,digit-1))) {
//                ;
//            }
//        } else if (digit == 5 ) {
//            while (hasDupes(numb =  gen.nextInt  ((int) (9*(Math.pow(10,digit-1)))) + (int) Math.pow(10,digit-1))) {
//                ;
//            }
//        } else if (digit == 6 ) {
//            while (hasDupes(numb =  gen.nextInt  ((int) (9*(Math.pow(10,digit-1)))) + (int) Math.pow(10,digit-1))) {
//                ;
//            }
//        }
//        if (cond.getExceptedNumb().size() > 1 && cond.getExceptedNumb().contains(numb)) {
//            getNumb(cond);
//        } else {
//            NumbStr = numb + "";
//
//        }
        NumbStr = numb + "";
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

