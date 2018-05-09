package model;

import javafx.beans.property.SimpleIntegerProperty;
import utils.Counters;

import java.io.Serializable;

public class Number implements Serializable{
    private static final long serialVersionUID = 7405172041950251804L;
    private final int digit;
    private final int bullCount;
    private final int cowCount;
    private final SimpleIntegerProperty ourDigit;
    private final SimpleIntegerProperty ourBulls;
    private final SimpleIntegerProperty ourCows;


    public int getOurDigit() {
        return ourDigit.get();
    }

    public SimpleIntegerProperty ourDigitProperty() {
        return ourDigit;
    }

    public void setOurDigit(int ourDigit) {
        this.ourDigit.set(ourDigit);
    }

    public int getOurBulls() {
        return ourBulls.get();
    }

    public SimpleIntegerProperty ourBullsProperty() {
        return ourBulls;
    }

    public void setOurBulls(int ourBulls) {
        this.ourBulls.set(ourBulls);
    }

    public int getOurCows() {
        return ourCows.get();
    }

    public SimpleIntegerProperty ourCowsProperty() {
        return ourCows;
    }

    public void setOurCows(int ourCows) {
        this.ourCows.set(ourCows);
    }

    public Number(final int number, final int inputNumber) {
        this.digit = number;
        int[] bullsAndCows = Counters.getCowsAndBullsFromNumber(number, inputNumber);
        this.bullCount = bullsAndCows[0];
        this.cowCount = bullsAndCows[1];
        this.ourDigit = new SimpleIntegerProperty(number);
        this.ourBulls = new SimpleIntegerProperty(bullsAndCows[0]);
        this.ourCows = new SimpleIntegerProperty(bullsAndCows[1]);

    }

    public int getDigit() {
        return digit;
    }

    public int getBullCount() {
        return bullCount;
    }

    public int getCowCount() {
        return cowCount;
    }

    public boolean compare(Number numb) {
        return bullCount == numb.getBullCount() && cowCount == numb.getCowCount();
    }

}
