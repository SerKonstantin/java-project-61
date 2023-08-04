package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void startGame(String rule, String[] questions, String[] correctAnswers) {
        String userName = getName();

        System.out.println(rule);

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            System.out.println(questions[i]);
            String answer = normalizeAnswer(getAnswer());

            var isCorrect = checkAnswer(answer, correctAnswers[i], userName);
            if (!isCorrect) {
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }


    public static String getName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }


    public static String getAnswer() {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    public static boolean checkAnswer(String answer, String correctAnswer, String userName) {
        if (answer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + userName + "!");
            return false;
        }
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
