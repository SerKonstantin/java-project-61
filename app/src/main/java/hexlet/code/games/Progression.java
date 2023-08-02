package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {
    public static void startGame() {
        String gameMode = "Progression";
        String question = "What number is missing in the progression?";

        Engine.startGame(gameMode, question);
    }


    public static String getRound() {
        final int minRowLength = 5;
        final int maxRowLength = 12;
        final int maxStartNumber = 25;
        final int maxStep = 10;

        var currentNumber = Util.getRandom(1, maxStartNumber);
        var rowLength = Util.getRandom(minRowLength, maxRowLength);
        var step = Util.getRandom(2, maxStep);

        int indexToHide = Util.getRandom(2, rowLength - 1);

        String correctAnswer = "";
        System.out.print("Question: ");
        for (int i = 0; i < rowLength; i++) {
            if (i == indexToHide) {
                System.out.print(".. ");
                correctAnswer = String.valueOf(currentNumber);
                currentNumber += step;
            } else {
                System.out.print(currentNumber + " ");
                currentNumber += step;
            }
        }
        System.out.println("");

        return correctAnswer;
    }
}
