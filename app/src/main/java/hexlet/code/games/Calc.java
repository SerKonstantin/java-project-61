package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static final String RULE = "What is the result of the expression?";
    public static final int MAX_RANDOM_NUMBER = 20;
    public static final String[] SIGNS = {"+", "-", "*"};


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
        String sign = SIGNS[Util.getRandom(0, SIGNS.length)];

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "Question: " + firstNumber + " " + sign + " " + secondNumber;
        questionAnswerPair[1] = getAnswer(firstNumber, secondNumber, sign);

        return questionAnswerPair;
    }


    public static String getAnswer(int firstNumber, int secondNumber, String sign) {
        switch (sign) {
            case "+":
                return String.valueOf(firstNumber + secondNumber);
            case "-":
                return String.valueOf(firstNumber - secondNumber);
            case "*":
                return String.valueOf(firstNumber * secondNumber);
            default:
                return "Error";
        }
    }
}
