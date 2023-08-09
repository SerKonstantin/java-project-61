package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GCD {
    public static final String RULE = "Find the greatest common divisor of given numbers.";
    public static final int MAX_RANDOM_NUMBER = 100;


    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
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
        questionAnswerPair[1] = getAnswer(firstNumber, secondNumber);

        return questionAnswerPair;
    }


    public static String getAnswer(int firstNumber, int secondNumber) {
        if (firstNumber < secondNumber) {
            var temp = firstNumber;
            firstNumber = secondNumber;
            secondNumber = temp;
        }

        while (secondNumber != 0) {
            int remainder = firstNumber % secondNumber;
            firstNumber = secondNumber;
            secondNumber = remainder;
        }

        return String.valueOf(firstNumber);
    }
}
