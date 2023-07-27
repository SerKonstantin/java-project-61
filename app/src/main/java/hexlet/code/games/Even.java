package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void startGame() {
        String userName = Engine.getName();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        final int maxRandomNumber = 50;
        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int number = Engine.getRandom(1, maxRandomNumber);
            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + number);

            String answer = Engine.getAnswer();

            // Normalising answer
            if (answer.matches("^(?i)(y|yes|yeah|yea|yep)$")) {
                answer = "yes";
            } else if (answer.matches("^(?i)(n|no|nope)$")) {
                answer = "no";
            }

            var isCorrect = Engine.checkAnswer(answer, correctAnswer, userName);
            if (!isCorrect) {
                return;
            }
        }

        Engine.congrats(userName);
    }
}
