package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {
    public static void startGame() {
        String gameMode = "Prime";
        String question = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        Engine.startGame(gameMode, question);
    }


    public static String getRound() {
        int number = generatePrimeWithChance();
        System.out.println("Question: " + number);
        return isPrime(number) ? "yes" : "no";
    }


    // Generate number with chance for prime and not prime 50/50
    public static int generatePrimeWithChance() {
        final int maxRandomNumber = 100;
        final float probability = 0.5F;

        int number;

        if (Math.random() < probability) {
            do {
                number = Util.getRandom(1, maxRandomNumber);
            } while (!isPrime(number));
        } else {
            do {
                number = Util.getRandom(1, maxRandomNumber);
            } while (isPrime(number));
        }

        return number;
    }


    public static boolean isPrime(int n) {
        // Wikipedia says '1' isn't a prime number, because it has only one divisor == 1
        if (n == 1) {
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
