package hexlet.code;

import java.util.Scanner;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        // Game modes
        // For appending new game mode one needs to append this HashMap and switch below
        HashMap<String, String> gameModes = new HashMap<>();
        gameModes.put("0", "Exit");
        gameModes.put("1", "Greet");
        gameModes.put("2", "Even");
        gameModes.put("3", "Calc");

        System.out.println("Please enter the game number and press Enter.");
        for (String key : gameModes.keySet()) {
            System.out.println(key + " - " + gameModes.get(key));
        }

        Scanner scanner = new Scanner(System.in);
        String gameModeChoice = scanner.next();
        if (gameModes.get(gameModeChoice) == null) {
            System.out.println("Error: Not a valid game number");
            return;
        } else {
            System.out.println("Your choice: " + gameModeChoice);
        }

        // For appending new game mode one needs to append this switch and HashMap "gameModes" above
        switch (gameModes.get(gameModeChoice)) {
            case "Exit":
                System.out.println("Exiting game now. Hope you had fun)");
                return;

            case "Greet":
                String userName = Cli.getName();
                return;

            case "Even":
                GameEven.startGame();
                return;

            case "Calc":
                GameCalc.startGame();
                return;

            // Default case only needed if somebody add new game mode to the HashMap and doesn't add it to the switch
            default:
                System.out.println("Error: Sorry, game isn't implemented yet");
                return;
        }
    }
}
