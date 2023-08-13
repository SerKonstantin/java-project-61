package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    public static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int MAX_RANDOM_NUMBER = 50;

    public static void startGame() {
        String[][] data = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            data[i] = getRound();
        }

        Engine.startGame(RULE, data);
    }

    public static String[] getRound() {
        int number = Util.getRandom(1, MAX_RANDOM_NUMBER);

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "Question: " + number;
        questionAnswerPair[1] = isEven(number) ? "yes" : "no";

        return questionAnswerPair;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}
