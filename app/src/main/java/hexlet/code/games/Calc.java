package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static final String CALC_RULE = "What is the result of the expression?";
    public static final int MAX_RANDOM_NUMBER = 20;
    public static final String[] SIGNS = {"+", "-", "*"};

    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            data[i] = getRound();
        }

        Engine.startGame(CALC_RULE, data);
    }


    public static String[] getRound() {
        String[] questionAnswerPair = new String[2];

        int firstNumber = Util.getRandom(1, MAX_RANDOM_NUMBER);
        int secondNumber = Util.getRandom(1, MAX_RANDOM_NUMBER);
        String sign = SIGNS[Util.getRandom(0, SIGNS.length)];

        questionAnswerPair[0] = "Question: " + firstNumber + " " + sign + " " + secondNumber;

        questionAnswerPair[1] = switch (sign) {
            case "+" -> String.valueOf(firstNumber + secondNumber);
            case "-" -> String.valueOf(firstNumber - secondNumber);
            case "*" -> String.valueOf(firstNumber * secondNumber);
            default -> "Error";
        };

        return questionAnswerPair;
    }
}
