package hexlet.code.games;

import hexlet.code.Randomize;
import hexlet.code.cli.Cli;

public class Progression implements IGame {
    private final int progressionLength = 10;

    private final int[] progression = new int[this.progressionLength];

    private int correctAnswer;

    public void explainRules() {
        Cli.printMsg("What number is missing in the progression?");
    }

    public String getQuestion() {
        final int min = 1;
        final int max = 100;
        final int startProgressionFrom = Randomize.getRandom(min, max);
        this.generateProgression(startProgressionFrom);

        final int minIndex = 0;
        final int maxIndex = 9;
        final int missingIndex = Randomize.getRandom(minIndex, maxIndex);

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
        final int minStep = 1;
        final int maxStep = 10;
        final int step = Randomize.getRandom(minStep, maxStep);

        this.progression[0] = startNumber;

        for (int i = 1; i < this.progression.length; i++) {
            this.progression[i] = startNumber + i * step;
        }
    }
}
