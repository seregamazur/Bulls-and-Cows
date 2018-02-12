package model;

import utils.GeneratorNumber;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ComputerGenerator {
    private Deque<Number> moves = new LinkedList<>();
    private Set<Integer> numbers = new HashSet<>();
    private GenerateStatus generateStatus;

    public void generateAndCheck(GeneratorNumber gen) {
        if (generateStatus == GenerateStatus.FINISHED) return;
        generateStatus = GenerateStatus.GENERATING;
        int number = gen.getNumber();
        continueGenerate(number, gen);
    }

    private void continueGenerate(int number, GeneratorNumber gen) {
        boolean success;
        do {
            while (numbers.contains(number)) {
                number = gen.getNumber();
            }
            numbers.add(number);
            success = true;
            for (Number move : moves) {
                Number numb = new Number(number, move.getNumber());
                if (!numb.compare(move)) {
                    success = false;
                    break;
                }
            }
        } while (!success);
        moves.add(new Number(number, InputGetter.getInputNumber()));
        if (number == InputGetter.getInputNumber()) generateStatus = GenerateStatus.FINISHED;
    }


    public Set<Integer> getNumbers() {
        return numbers;
    }

    public Deque<Number> getMoves() {
        return moves;
    }

    public GenerateStatus getGenerateStatus() {
        return generateStatus;
    }

    public void setGenerateStatus(GenerateStatus generateStatus) {
        this.generateStatus = generateStatus;
    }

    public enum GenerateStatus {
        GENERATING,
        FINISHED
    }
}
