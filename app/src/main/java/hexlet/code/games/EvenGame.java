package hexlet.code.games;

import hexlet.code.Randomize;
import hexlet.code.cli.Cli;

public final class EvenGame implements IGame {
    @Override
    public void explainRules() {
        Cli.printMsg("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public String getQuestion() {
        final int min = 0;
        final int max = 1000;

        int question = Randomize.getRandom(min, max);
        return String.valueOf(question);
    }

    public String getCorrectAnswer(String question) {
        int intQuestion = Integer.parseInt(question);

        if (isEven(intQuestion)) {
            return "yes";
        }

        return "no";
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }
}
