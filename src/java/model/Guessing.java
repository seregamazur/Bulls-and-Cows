package model;

import utils.GeneratorNumber;

import java.io.Serializable;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Guessing implements Serializable{
    private static final long serialVersionUID = 6405172041950251804L;
    private Deque<Number> numbers = new LinkedList<>();
    private Set<Integer> usageNumbers = new HashSet<>();
    private int guesses;
    private Guessing.GenerateStatus guessingStatus;

    public void check(GeneratorNumber gen) {
        usageNumbers.add(InputGetter.getInputNumb());
        Number numb = new Number(InputGetter.getInputNumb(), gen.getGeneratedNumber());
        numbers.add(numb);
        guesses++;
        if (numb.getBullCount() == gen.getDigits()) guessingStatus = GenerateStatus.FINISHED;
        else guessingStatus = GenerateStatus.GUESSING;
    }

    public Set<Integer> getUsageNumbers() {
        return usageNumbers;
    }

    public enum GenerateStatus {
        GUESSING,
        FINISHED
    }

    public GenerateStatus getGenerateStatus() {
        return guessingStatus;
    }

    public Deque<Number> getNumbers() {
        return numbers;
    }

    public int getGuesses() {
        return guesses;
    }
}
