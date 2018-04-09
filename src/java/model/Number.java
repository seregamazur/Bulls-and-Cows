package model;

import utils.Counters;

public class Number {
    private final int number;
    private final int bullCount;
    private final int cowCount;


    public Number(final int number, final int inputNumber) {
        this.number = number;
        int[] bullsAndCows = Counters.getCowsAndBullsFromNumber(number, inputNumber);
        this.bullCount = bullsAndCows[0];
        this.cowCount = bullsAndCows[1];
    }

    public int getNumber() {
        return number;
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
                "number=" + number +
                ", bullCount=" + bullCount +
                ", cowCount=" + cowCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        final Number obj = (Number) o;
        if (obj == null){
            return false;}
            else if(this.getClass() != obj.getClass()){
            return false;}else{
        return this.getNumber() == obj.getNumber();
    }}

    public boolean compare(Number numb) {
        return bullCount == numb.getBullCount() && cowCount == numb.getCowCount();
    }

}
