package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static void startGame() {
        String userName = Engine.getName();

        System.out.println("What number is missing in the progression?");

        final int minRowLength = 5;
        final int maxRowLength = 12;
        final int maxStartNumber = 25;
        final int maxStep = 10;

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            var currentNumber = Engine.getRandom(1, maxStartNumber);
            var rowLength = Engine.getRandom(minRowLength, maxRowLength);
            var step = Engine.getRandom(2, maxStep);

            int indexToHide = Engine.getRandom(2, rowLength - 1);

            String correctAnswer = "";
            System.out.print("Question: ");
            for (int j = 0; j < rowLength; j++) {
                if (j == indexToHide) {
                    System.out.print(".. ");
                    correctAnswer = String.valueOf(currentNumber);
                    currentNumber += step;
                } else {
                    System.out.print(currentNumber + " ");
                    currentNumber += step;
                }
            }
            System.out.println("");

            String answer = Engine.getAnswer();

            var isCorrect = Engine.checkAnswer(answer, correctAnswer, userName);
            if (!isCorrect) {
                return;
            }
        }

        Engine.congrats(userName);
    }
}
