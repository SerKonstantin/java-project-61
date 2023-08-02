package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GCD {
    public static void startGame() {
        String gameMode = "GCD";
        String question = "Find the greatest common divisor of given numbers.";

        Engine.startGame(gameMode, question);
    }


    public static String getRound() {
        final int maxRandomGCD = 10;
        final int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        int originGCD = Util.getRandom(1, maxRandomGCD);
        int firstNumber = originGCD * primeNumbers[Util.getRandom(0, primeNumbers.length)];
        int secondNumber = originGCD * primeNumbers[Util.getRandom(0, primeNumbers.length)];

        while (firstNumber == secondNumber) {
            secondNumber = originGCD * primeNumbers[Util.getRandom(0, primeNumbers.length)];
        }

        System.out.println("Question: " + firstNumber + " " + secondNumber);

        return String.valueOf(originGCD);
    }
}
