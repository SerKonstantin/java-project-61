package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.HashMap;
import java.util.Map;

public class Calc {
    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String rule = "What is the result of the expression?";
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
        final int maxRandomNumber = 20;
        final String[] signs = {"+", "-", "*"};

        int firstNumber = Util.getRandom(1, maxRandomNumber);
        int secondNumber = Util.getRandom(1, maxRandomNumber);
        String sign = signs[Util.getRandom(0, signs.length)];

        var answer = switch (sign) {
            case "+" -> String.valueOf(firstNumber + secondNumber);
            case "-" -> String.valueOf(firstNumber - secondNumber);
            case "*" -> String.valueOf(firstNumber * secondNumber);
            default -> "Error";
        };

        Map<String, String> questionAndAnswer = new HashMap<>();
        questionAndAnswer.put("question", "Question: " + firstNumber + " " + sign + " " + secondNumber);
        questionAndAnswer.put("answer", answer);

        return questionAndAnswer;
    }
}
