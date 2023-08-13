package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {
    public static final String RULE = "What number is missing in the progression?";
    public static final int MIN_ROW_LENGTH = 5;
    public static final int MAX_ROW_LENGTH = 12;
    public static final int MAX_START_NUMBER = 25;
    public static final int MAX_STEP = 10;

    public static void startGame() {
        String[][] data = new String[Engine.ROUNDS_COUNT][2];

        for (int i = 0; i < Engine.ROUNDS_COUNT; i++) {
            data[i] = getRound();
        }

        Engine.startGame(RULE, data);
    }

    public static String[] getRound() {
        var startNumber = Util.getRandom(1, MAX_START_NUMBER);
        var progressionLength = Util.getRandom(MIN_ROW_LENGTH, MAX_ROW_LENGTH);
        var step = Util.getRandom(2, MAX_STEP);
        int indexToHide = Util.getRandom(2, progressionLength - 1);

        int[] progression = getProgression(startNumber, progressionLength, step);

        StringBuilder sb = new StringBuilder("Question: ");
        for (int i = 0; i < progressionLength; i++) {
            if (i == indexToHide) {
                sb.append(".. ");
            } else {
                sb.append(progression[i]).append(" ");
            }
        }

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = sb.toString();
        questionAnswerPair[1] = String.valueOf(progression[indexToHide]);

        return questionAnswerPair;
    }

    public static int[] getProgression(int startNumber, int progressionLength, int step) {
        int[] progression = new int[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            progression[i] = startNumber + (i * step);
        }

        return progression;
    }
}
