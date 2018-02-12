package model;

import utils.GeneratorNumber;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Guessing {
    private Deque<Number> Numbers = new LinkedList<>();
    private Set<Integer> usageNumbers = new HashSet<>();
    private int guesses;
    private Guessing.GenerateStatus guessingStatus;

    public void Check(GeneratorNumber gen, InputGetter getter) {
        usageNumbers.add(getter.getInputNumb());
        Number numb = new Number(getter.getInputNumb(), gen.getGeneratedNumber());
        Numbers.add(numb);
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
        return Numbers;
    }

    public int getGuesses() {
        return guesses;
    }
}
