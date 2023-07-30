package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void startGame() {
        String userName = Engine.getName();

        System.out.println("Find the greatest common divisor of given numbers.");

        final int maxRandomGCD = 10;
        final int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int originGCD = Engine.getRandom(1, maxRandomGCD);
            int firstNumber = originGCD * primeNumbers[Engine.getRandom(0, primeNumbers.length)];
            int secondNumber = originGCD * primeNumbers[Engine.getRandom(0, primeNumbers.length)];

            while (firstNumber == secondNumber) {
                secondNumber = originGCD * primeNumbers[Engine.getRandom(0, primeNumbers.length)];
            }

            String correctAnswer = String.valueOf(originGCD);

            System.out.println("Question: " + firstNumber + " " + secondNumber);

            String answer = Engine.getAnswer();

            var isCorrect = Engine.checkAnswer(answer, correctAnswer, userName);
            if (!isCorrect) {
                return;
            }
        }

        Engine.congrats(userName);
    }
}
