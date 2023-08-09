package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GCD {
    public static final String GCD_RULE = "Find the greatest common divisor of given numbers.";
    public static final int MAX_RANDOM_GCD = 10;
    public static final int[] PRIME_NUMBERS = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            data[i] = getRound();
        }

        Engine.startGame(GCD_RULE, data);
    }


    public static String[] getRound() {
        String[] questionAnswerPair = new String[2];

        int originGCD = Util.getRandom(1, MAX_RANDOM_GCD);
        int firstNumber = originGCD * PRIME_NUMBERS[Util.getRandom(0, PRIME_NUMBERS.length)];
        int secondNumber = originGCD * PRIME_NUMBERS[Util.getRandom(0, PRIME_NUMBERS.length)];

        while (firstNumber == secondNumber) {
            secondNumber = originGCD * PRIME_NUMBERS[Util.getRandom(0, PRIME_NUMBERS.length)];
        }

        questionAnswerPair[0] = "Question: " + firstNumber + " " + secondNumber;
        questionAnswerPair[1] = String.valueOf(originGCD);

        return questionAnswerPair;
    }
}
