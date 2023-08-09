package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

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
            case "1" -> Cli.getName();
            case "2" -> Even.startGame();
            case "3" -> Calc.startGame();
            case "4" -> GCD.startGame();
            case "5" -> Progression.startGame();
            case "6" -> Prime.startGame();
            default -> System.out.println("Error: Not a valid game number");
        }
    }
}
