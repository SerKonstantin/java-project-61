package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("""
                0 - Exit
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime""");

        Scanner scanner = new Scanner(System.in);
        String gameModeChoice = scanner.next();

        System.out.println("Your choice: " + gameModeChoice);

        switch (gameModeChoice) {
            case "0" -> System.out.println("Exiting game now. Hope you had fun)");
            case "1" -> Engine.getName();
            case "2" -> hexlet.code.games.Even.startGame();
            case "3" -> hexlet.code.games.Calc.startGame();
            case "4" -> hexlet.code.games.GCD.startGame();
            case "5" -> hexlet.code.games.Progression.startGame();
            case "6" -> hexlet.code.games.Prime.startGame();
            default -> System.out.println("Error: Not a valid game number");
        }
    }
}
