package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {
    public static final String PROGRESSION_RULE = "What number is missing in the progression?";
    public static final int MIN_ROW_LENGTH = 5;
    public static final int MAX_ROW_LENGTH = 12;
    public static final int MAX_START_NUMBER = 25;
    public static final int MAX_STEP = 10;

    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            data[i] = getRound();
        }

        Engine.startGame(PROGRESSION_RULE, data);
    }


    public static String[] getRound() {
        String[] questionAnswerPair = new String[2];

        var currentNumber = Util.getRandom(1, MAX_START_NUMBER);
        var rowLength = Util.getRandom(MIN_ROW_LENGTH, MAX_ROW_LENGTH);
        var step = Util.getRandom(2, MAX_STEP);
        int indexToHide = Util.getRandom(2, rowLength - 1);

        String answer = "";
        StringBuilder question = new StringBuilder("Question: ");
        for (int i = 0; i < rowLength; i++) {
            if (i == indexToHide) {
                question.append(".. ");
                answer = String.valueOf(currentNumber);
            } else {
                question.append(currentNumber).append(" ");
            }
            currentNumber += step;
        }

        questionAnswerPair[0] = question.toString();
        questionAnswerPair[1] = answer;

        return questionAnswerPair;
    }
}
