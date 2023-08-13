package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GCD {
    public static final String RULE = "Find the greatest common divisor of given numbers.";
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        String[][] data = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            data[i] = getRound();
        }

        Engine.startGame(RULE, data);
    }

    public static String[] getRound() {
        int firstNumber = Util.getRandom(1, MAX_RANDOM_NUMBER);
        int secondNumber = Util.getRandom(1, MAX_RANDOM_NUMBER);

        while (firstNumber == secondNumber) {
            secondNumber = Util.getRandom(1, MAX_RANDOM_NUMBER);
        }

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "Question: " + firstNumber + " " + secondNumber;
        int result = findGCD(firstNumber, secondNumber);
        questionAnswerPair[1] = String.valueOf(result);

        return questionAnswerPair;
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}
