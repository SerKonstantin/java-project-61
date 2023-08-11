package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static final String RULE = "What is the result of the expression?";
    public static final int MAX_RANDOM_NUMBER = 20;
    public static final String[] SIGNS = {"+", "-", "*"};

    public static void startGame() throws Exception {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            try {
                data[i] = getRound();
            } catch (Exception error) {
                System.out.println("Error: " + error.getMessage());
                return;
            }
        }

        Engine.startGame(RULE, data);
    }

    public static String[] getRound() throws Exception {
        int firstNumber = Util.getRandom(1, MAX_RANDOM_NUMBER);
        int secondNumber = Util.getRandom(1, MAX_RANDOM_NUMBER);
        String sign = SIGNS[Util.getRandom(0, SIGNS.length)];

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "Question: " + firstNumber + " " + sign + " " + secondNumber;
        int result = calculate(firstNumber, secondNumber, sign);
        questionAnswerPair[1] = String.valueOf(result);

        return questionAnswerPair;
    }

    public static int calculate(int a, int b, String sign) throws Exception {
        switch (sign) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new Exception("Unknown symbol");
        }
    }
}
