package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

import java.util.HashMap;
import java.util.Map;

public class GCD {
    public static void startGame() {
        var questionsCount = Engine.ROUNDS_COUNT;
        String rule = "Find the greatest common divisor of given numbers.";
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
        final int maxRandomGCD = 10;
        final int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        int originGCD = Util.getRandom(1, maxRandomGCD);
        int firstNumber = originGCD * primeNumbers[Util.getRandom(0, primeNumbers.length)];
        int secondNumber = originGCD * primeNumbers[Util.getRandom(0, primeNumbers.length)];

        while (firstNumber == secondNumber) {
            secondNumber = originGCD * primeNumbers[Util.getRandom(0, primeNumbers.length)];
        }

        Map<String, String> questionAndAnswer = new HashMap<>();
        questionAndAnswer.put("question", "Question: " + firstNumber + " " + secondNumber);
        questionAndAnswer.put("answer", String.valueOf(originGCD));

        return questionAndAnswer;
    }
}
