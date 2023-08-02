package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static void startGame() {
        String gameMode = "Calc";
        String question = "What is the result of the expression?";

        Engine.startGame(gameMode, question);
    }


    public static String getRound() {
        final int maxRandomNumber = 20;
        final String[] signs = {"+", "-", "*"};

        int firstNumber = Util.getRandom(1, maxRandomNumber);
        int secondNumber = Util.getRandom(1, maxRandomNumber);
        String sign = signs[Util.getRandom(0, signs.length)];

        System.out.println("Question: " + firstNumber + " " + sign + " " + secondNumber);

        return switch (sign) {
            case "+" -> String.valueOf(firstNumber + secondNumber);
            case "-" -> String.valueOf(firstNumber - secondNumber);
            case "*" -> String.valueOf(firstNumber * secondNumber);
            default -> "Error";
        };
    }
}
