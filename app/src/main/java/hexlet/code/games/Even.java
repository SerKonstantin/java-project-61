package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    public static final String EVEN_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int MAX_RANDOM_NUMBER = 50;

    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            data[i] = getRound();
        }

        Engine.startGame(EVEN_RULE, data);
    }


    public static String[] getRound() {
        String[] questionAnswerPair = new String[2];
        int number = Util.getRandom(1, MAX_RANDOM_NUMBER);
        questionAnswerPair[0] = "Question: " + number;
        questionAnswerPair[1] = number % 2 == 0 ? "yes" : "no";

        return questionAnswerPair;
    }
}
