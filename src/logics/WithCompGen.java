package logics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class WithCompGen {
    private String compNumb;
    private int numb;
    private int digit;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<Integer> myList = new ArrayList<>();
    private Random gen = new Random();

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    public String getCompNumb() {
        return compNumb;
    }

    public void setCompNumb(String compNumb) {
        this.compNumb = compNumb;
    }

    public ArrayList<Integer> getMyList() {
        return myList;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }


    private int getSum(String a, String b) {
        int cowcount = 0;
        int bullcount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.contains(b.charAt(i) + "")) {
                cowcount++;
            } else if (b.charAt(i) == a.charAt(i)) {
                bullcount++;

            }
        }
        return bullcount + cowcount;
    }

    public void getNumber(Condition cond) {
        boolean flag = false;
        if (digit == 3 || digit == 4 || digit == 5 || digit == 6) {
            while (!flag) {
                numb = gen.nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1);
                flag = hasDupes(numb);
                if (cond.getLuckyCount() == 0) continue;
            }
        }
        if (flag) {
            setCompNumb(numb + "");
            arrayList.add(getCompNumb());
            boolean flag1 = getSum(getCompNumb(), cond.getGuessStr()) >= cond.getLuckyCount();
            if (getSum(getCompNumb(), cond.getGuessStr()) == 0) {
                getNumber(cond);
            } else {
                if (flag1) {
                    myList.add(Integer.parseInt(getCompNumb()));

                } else {
                    getNumber(cond);
                }
            }
        }
    }

    private boolean hasDupes(int num) {
        for (boolean[] digs = new boolean[10]; num > 0; num /= 10) {
            if (digs[num % 10]) {
                return false;
            }
            digs[num % 10] = true;
        }
        return true;
    }

    public void read() {
        Properties props = new Properties();
        InputStream input;
        try {
            File f = new File("settings.properties");
            input = new FileInputStream(f);
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setDigit(Integer.parseInt(props.getProperty("DigitsCount")));
    }

}