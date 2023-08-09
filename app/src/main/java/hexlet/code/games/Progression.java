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
        var questionsCount = Engine.ROUNDS_COUNT;
        String[][] data = new String[questionsCount][2];

        for (int i = 0; i < questionsCount; i++) {
            data[i] = getRound();
        }

        Engine.startGame(RULE, data);
    }


    public static String[] getRound() {
        var startNumber = Util.getRandom(1, MAX_START_NUMBER);
        var rowLength = Util.getRandom(MIN_ROW_LENGTH, MAX_ROW_LENGTH);
        var step = Util.getRandom(2, MAX_STEP);
        int indexToHide = Util.getRandom(2, rowLength - 1);

        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = getQuestion(startNumber, rowLength, step, indexToHide);
        questionAnswerPair[1] = String.valueOf(startNumber + step * indexToHide);

        return questionAnswerPair;
    }


    public static String getQuestion(int currentNumber, int rowLength, int step, int indexToHide) {
        StringBuilder question = new StringBuilder("Question: ");
        for (int i = 0; i < rowLength; i++) {
            if (i == indexToHide) {
                question.append(".. ");
            } else {
                question.append(currentNumber).append(" ");
            }
            currentNumber += step;
        }
        return question.toString();
    }
}
