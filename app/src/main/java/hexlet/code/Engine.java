package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int ROUNDS_COUNT = 3;

    public static String getName() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        return userName;
    }


    public static int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
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


    public static void congrats(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

}
