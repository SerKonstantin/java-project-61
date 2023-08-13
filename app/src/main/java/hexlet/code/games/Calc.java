package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static final String RULE = "What is the result of the expression?";
    public static final int MAX_RANDOM_NUMBER = 20;
    public static final String[] SIGNS = {"+", "-", "*"};

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
        String sign = SIGNS[Util.getRandom(0, SIGNS.length)];

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "Question: " + firstNumber + " " + sign + " " + secondNumber;
        int result = calculate(firstNumber, secondNumber, sign);
        questionAnswerPair[1] = String.valueOf(result);

        return questionAnswerPair;
    }

    public static int calculate(int a, int b, String sign) {
        switch (sign) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new RuntimeException("Unknown symbol");
        }
    }
}
