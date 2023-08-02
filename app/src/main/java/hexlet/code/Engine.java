package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class Engine {
    public static void startGame(String gameMode, String question) {
        String userName = getName();

        System.out.println(question);

        final int roundsCount = 3;
        for (int i = 0; i < roundsCount; i++) {
            String correctAnswer = switch (gameMode) {
                case "Even" -> Even.getRound();
                case "Calc" -> Calc.getRound();
                case "GCD" -> GCD.getRound();
                case "Progression" -> Progression.getRound();
                case "Prime" -> Prime.getRound();
                default -> "Error";
            };

            if (correctAnswer.equals("Error")) {
                System.out.println("Error: Game mode not implemented");
                return;
            }

            String answer = normalizeAnswer(getAnswer());

            var isCorrect = checkAnswer(answer, correctAnswer, userName);
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
