package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.List;

public class Prime {
    public static void startGame() {
        String userName = Engine.getName();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        final int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                                    79, 83, 89, 97};
        final int maxRandomNumber = 100;

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number;
            String correctAnswer;

            // Generate number with chance for prime and not prime 50/50
            if (Math.random() < 0.5) {
                number = primeNumbers[Engine.getRandom(0, primeNumbers.length)];
                correctAnswer = "yes";
            } else {
                List<int[]> primeNumbersAsList = Arrays.asList(primeNumbers);
                do {
                    number = Engine.getRandom(1, maxRandomNumber);
                } while (primeNumbersAsList.contains(number));
                correctAnswer = "no";
            }

            System.out.println("Question: " + number);

            // Get answer from user
            String answer = Engine.normalizeAnswer(Engine.getAnswer());

            var isCorrect = Engine.checkAnswer(answer, correctAnswer, userName);
            if (!isCorrect) {
                return;
            }
        }

        Engine.congrats(userName);
    }
}
