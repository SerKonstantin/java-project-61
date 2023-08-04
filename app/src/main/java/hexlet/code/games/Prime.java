package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.HashMap;
import java.util.Map;

public class Prime {
    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];

        for (int i = 0; i < questionsCount; i++) {
            var questionAndAnswer = getRound();
            questions[i] = questionAndAnswer.get("question");
            answers[i] = questionAndAnswer.get("answer");
        }

        Engine.startGame(rule, questions, answers);
    }


    public static Map<String, String> getRound() {
        int number = generatePrimeWithChance();
        var answer = isPrime(number) ? "yes" : "no";

        Map<String, String> questionAndAnswer = new HashMap<>();
        questionAndAnswer.put("question", "Question: " + number);
        questionAndAnswer.put("answer", answer);

        return questionAndAnswer;
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
