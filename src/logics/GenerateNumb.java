package logics;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class GenerateNumb {

    private String NumbStr;
    private Random gen = new Random();
    private int numb;
    private int digit;

    public ArrayList<Integer> getMyList() {
        return myList;
    }

    private ArrayList<Integer> myList = new ArrayList<>();

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    private ArrayList<String> arrayList = new ArrayList<>();

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


    public void getNumber(Condition cond) {
        boolean flag = false;
        if (digit == 3 || digit == 4 || digit == 5 || digit == 6) {
            while (!flag) {
                numb = gen.nextInt((int) (9 * (Math.pow(10, digit - 1)))) + (int) Math.pow(10, digit - 1);
                flag = hasDupes(numb);
                if(cond.getLuckyCount()==0) continue;}}
                if (flag) {
                    setNumbStr(numb + "");
                    arrayList.add(getNumbStr());
                boolean flag1 = Move.getSum(getNumbStr(), cond.getGuessStr()) >= cond.getLuckyCount();
                if(Move.getSum(getNumbStr(), cond.getGuessStr()) == 0){getNumber(cond);}else{
                    System.out.println(Move.getSum(getNumbStr(), cond.getGuessStr()));
                if (flag1 ) {
                    myList.add(Integer.parseInt(getNumbStr()));

                }
                else {
                    getNumber(cond);
                }
            }}
                }


    public void read() {
        Properties props = new Properties();
        InputStream input = null;
        try {
            File f = new File("settings.properties");
            input = new FileInputStream(f);
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();}
        setDigit(Integer.parseInt(props.getProperty("DigitsCount")));
    }

    public boolean hasDupes(int num) {
        for (boolean[] digs = new boolean[10]; num > 0; num /= 10) {
            if (digs[num % 10]) {
                return false;
            }
            digs[num % 10] = true;
        }
        return true;
    }
}

