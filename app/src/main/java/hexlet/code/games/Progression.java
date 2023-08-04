package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.HashMap;
import java.util.Map;

public class Progression {
    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String rule = "What number is missing in the progression?";
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];

        for (int i = 0; i < questionsCount; i++) {
            var questionAndAnswer = getRound();
            questions[i] = questionAndAnswer.get("question");
            answers[i] = questionAndAnswer.get("answer");
        }

        Engine.startGame(rule, questions, answers);
    }


    public static Map<String, String> getRound() {
        final int minRowLength = 5;
        final int maxRowLength = 12;
        final int maxStartNumber = 25;
        final int maxStep = 10;

        var currentNumber = Util.getRandom(1, maxStartNumber);
        var rowLength = Util.getRandom(minRowLength, maxRowLength);
        var step = Util.getRandom(2, maxStep);
        int indexToHide = Util.getRandom(2, rowLength - 1);

        String answer = "";
        String question = "Question: ";
        for (int i = 0; i < rowLength; i++) {
            if (i == indexToHide) {
                question = question.concat(".. ");
                answer = String.valueOf(currentNumber);
            } else {
                question = question.concat(currentNumber + " ");
            }
            currentNumber += step;
        }

        Map<String, String> questionAndAnswer = new HashMap<>();
        questionAndAnswer.put("question", question);
        questionAndAnswer.put("answer", answer);

        return questionAndAnswer;
    }
}
