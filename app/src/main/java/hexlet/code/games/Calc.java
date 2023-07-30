package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void startGame() {
        String userName = Engine.getName();

        System.out.println("What is the result of the expression?");

        final int maxRandomNumber = 20;
        final String[] signs = {"+", "-", "*"};

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            int firstNumber = Engine.getRandom(1, maxRandomNumber);
            int secondNumber = Engine.getRandom(1, maxRandomNumber);
            String sign = signs[Engine.getRandom(0, signs.length)];

            // Calculate correct answer
            String correctAnswer;
            switch (sign) {
                case "+":
                    correctAnswer = String.valueOf(firstNumber + secondNumber);
                    break;
                case "-":
                    correctAnswer = String.valueOf(firstNumber - secondNumber);
                    break;
                case "*":
                    correctAnswer = String.valueOf(firstNumber * secondNumber);
                    break;
                default:
                    System.out.println("Error: Sign is not implemented");
                    return;
            }

            System.out.println("Question: " + firstNumber + " " + sign + " " + secondNumber);

            String answer = Engine.getAnswer();

            var isCorrect = Engine.checkAnswer(answer, correctAnswer, userName);
            if (!isCorrect) {
                return;
            }
        }

        Engine.congrats(userName);
    }
}
