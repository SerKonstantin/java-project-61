package hexlet.code;

import java.util.Scanner;

public class GameCalc {
    public static void startGame() {
        final int roundsCount = 3;
        final int maxRandomNumber = 20;

        String userName = Cli.getName();
        System.out.println("What is the result of the expression?");

        final String[] signs = {"+", "-", "*"};
        int numberOfSigns = signs.length;

        for (int i = 0; i < roundsCount; i++) {
            int firstNumber = (int) (Math.random() * maxRandomNumber + 1);
            int secondNumber = (int) (Math.random() * maxRandomNumber + 1);
            String sign = signs[(int) (Math.random() * numberOfSigns)];

            System.out.println("Question: " + firstNumber + " " + sign + " " + secondNumber);

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

            System.out.print("Your answer: ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
    }
}
