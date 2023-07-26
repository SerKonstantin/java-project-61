package hexlet.code;

import java.util.Scanner;

public class GameEven {
    public static void startGame() {
        final int roundsCount = 3; // Wanted to name ROUNDS_COUNT, but it doesn't satisfy linter
        // checkstyle.xml taken from here:
        // https://github.com/hexlet-boilerplates/java-package/blob/main/app/config/checkstyle/checkstyle.xml

        String userName = Cli.getName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < roundsCount; i++) {
            int number = (int) (Math.random() * 50 + 1);
            System.out.println("Question: " + number);

            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            System.out.print("Your answer: ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();

            if (answer.matches("^(?i)(y|yes|yeah|yea|yep)$")) {
                answer = "yes";
            } else if (answer.matches("^(?i)(n|no|nope)$")) {
                answer = "no";
            }

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
