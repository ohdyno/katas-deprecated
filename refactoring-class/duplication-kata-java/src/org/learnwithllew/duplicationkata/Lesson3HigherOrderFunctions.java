package org.learnwithllew.duplicationkata;

import java.util.function.Function;

public class Lesson3HigherOrderFunctions extends Song {
    private class NumberGenerator {
        private final Function<Integer, Integer> getNextNumber;

        private int currentNumber;

        NumberGenerator(int startPoint, Function<Integer, Integer> getNextNumber) {
            this.getNextNumber = getNextNumber;
            currentNumber = startPoint;
        }

        int getNextNumber() {
            currentNumber = getNextNumber.apply(currentNumber);
            return currentNumber;
        }
    }

    public void singCheers() {
        SingALing("Who do we appreciate?", new NumberGenerator(0, (n) -> n + 2));
        SingALing("These are the primes, that we find fine!", new NumberGenerator(13, this::getNextPrime));
    }

    private void SingALing(String lastLine, NumberGenerator numberGen) {
        for (int i = 0; i < 4; i++) {
            sing(numberGen.getNextNumber() + "! ");
        }
        sing(lastLine);
    }

    private int getNextPrime(int number) {
        switch (number) {
            case 13:
                return 17;
            case 17:
                return 19;
            case 19:
                return 23;
            case 23:
                return 29;
        }
        return 0;
    }
}
