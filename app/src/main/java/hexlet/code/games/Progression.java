package hexlet.code.games;

import hexlet.code.Randomize;
import hexlet.code.cli.Cli;

import java.util.Arrays;

public class Progression implements IGame {
    private final int[] progression = new int[10];

    private int correctAnswer;

    public void explainRules() {
        Cli.printMsg("What number is missing in the progression?");
    }

    public String getQuestion() {
        int min = 1;
        int max = 100;
        int startProgressionFrom = Randomize.getRandom(min, max);
        this.generateProgression(startProgressionFrom);

        int minIndex = 0;
        int maxIndex = 9;
        int missingIndex = Randomize.getRandom(minIndex, maxIndex);

        StringBuilder question = new StringBuilder();

        for (int num : progression) {
            if (progression[0] != num) {
                question.append(" ");
            }

            if (progression[missingIndex] == num) {
                question.append("..");
                this.correctAnswer = num;
            } else {
                question.append(num);
            }
        }

        return question.toString();
    }

    public String getCorrectAnswer(String question) {
        return String.valueOf(this.correctAnswer);
    }

    private void generateProgression(int startNumber) {
        int minStep = 1;
        int maxStep = 10;
        int step = Randomize.getRandom(minStep, maxStep);

        this.progression[0] = startNumber;

        for (int i = 1; i < this.progression.length; i++) {
            this.progression[i] = startNumber + i * step;
        }
    }
}
