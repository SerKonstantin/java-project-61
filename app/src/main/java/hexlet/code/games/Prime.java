package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {
    public static final String RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int MAX_RANDOM_NUMBER = 100;

    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            data[i] = getRound();
        }

        Engine.startGame(RULE, data);
    }

    public static String[] getRound() {
        int number = Util.getRandom(1, MAX_RANDOM_NUMBER);

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "Question: " + number;
        questionAnswerPair[1] = isPrime(number) ? "yes" : "no";

        return questionAnswerPair;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
