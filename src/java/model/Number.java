package model;

import utils.Counters;

import java.io.Serializable;

public class Number implements Serializable{
    private static final long serialVersionUID = 7405172041950251804L;
    private final int digit;
    private final int bullCount;
    private final int cowCount;


    protected Number(final int number, final int inputNumber) {
        this.digit = number;
        int[] bullsAndCows = Counters.getCowsAndBullsFromNumber(number, inputNumber);
        this.bullCount = bullsAndCows[0];
        this.cowCount = bullsAndCows[1];
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

    @Override
    public String toString() {
        return "Number{" +
                "number=" + digit +
                ", bullCount=" + bullCount +
                ", cowCount=" + cowCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) throw new IllegalArgumentException("Null is equals function");
        if (this.getClass() != o.getClass())
            return false;
        final Number obj = (Number) o;
        return this.getClass() == obj.getClass() && this.getDigit() == obj.getDigit();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public boolean compare(Number numb) {
        return bullCount == numb.getBullCount() && cowCount == numb.getCowCount();
    }

}
