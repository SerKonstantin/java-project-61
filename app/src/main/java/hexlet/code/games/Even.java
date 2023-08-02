package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    public static void startGame() {
        String gameMode = "Even";
        String question = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        Engine.startGame(gameMode, question);
    }


    public static String getRound() {
        final int maxRandomNumber = 50;
        int number = Util.getRandom(1, maxRandomNumber);
        String correctAnswer = number % 2 == 0 ? "yes" : "no";

        System.out.println("Question: " + number);

        return correctAnswer;
    }
}
