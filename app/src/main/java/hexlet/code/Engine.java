package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void startGame(String rule, String[][] data) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rule);

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            System.out.println(data[i][0]);
            System.out.print("Your answer: ");
            String answer = normalizeAnswer(scanner.next());

            if (answer.equals(data[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + data[i][1]
                                   + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }


    public static String normalizeAnswer(String answer) {
        if (answer.matches("^(?i)(y|yes|yeah|yea|yep)$")) {
            return "yes";
        } else if (answer.matches("^(?i)(n|no|nope)$")) {
            return "no";
        } else {
            return answer;
        }
    }
}
