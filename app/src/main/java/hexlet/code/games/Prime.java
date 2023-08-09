package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {
    public static final String PRIME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int MAX_RANDOM_NUMBER = 100;
    public static final float PROBABILITY = 0.5F;

    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            data[i] = getRound();
        }

        Engine.startGame(PRIME_RULE, data);
    }


    public static String[] getRound() {
        int number = generatePrimeWithChance();

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = "Question: " + number;
        questionAnswerPair[1] = isPrime(number) ? "yes" : "no";

        return questionAnswerPair;
    }


    // Generate number with a "probability" chance to be a prime number
    public static int generatePrimeWithChance() {
        int number;

        if (Math.random() < PROBABILITY) {
            do {
                number = Util.getRandom(1, MAX_RANDOM_NUMBER);
            } while (!isPrime(number));
        } else {
            do {
                number = Util.getRandom(1, MAX_RANDOM_NUMBER);
            } while (isPrime(number));
        }

        return number;
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
