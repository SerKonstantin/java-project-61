package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.HashMap;
import java.util.Map;

public class Even {
    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        final int maxRandomNumber = 50;
        int number = Util.getRandom(1, maxRandomNumber);
        String answer = number % 2 == 0 ? "yes" : "no";

        Map<String, String> questionAndAnswer = new HashMap<>();
        questionAndAnswer.put("question", "Question: " + number);
        questionAndAnswer.put("answer", answer);

        return questionAndAnswer;
    }
}
