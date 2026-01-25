package hexlet.code.games;

import hexlet.code.Randomize;
import hexlet.code.cli.Cli;
import hexlet.code.games.interfaces.IGame;

public final class GCD implements IGame {
    private int num1;
    private int num2;

    public void explainRules() {
        Cli.printMsg("Find the greatest common divisor of given numbers.");
    }

    public String getQuestion() {
        final int min = 0;
        final int max = 100;

        this.num1 = Randomize.getRandom(min, max);
        this.num2 = Randomize.getRandom(min, max);

        return this.num1 + " " + this.num2;
    }

    public String getCorrectAnswer(String question) {
        int a = Math.abs(this.num1);
        int b = Math.abs(this.num2);

        while (b != 0) {
            int temp = b;

            b = a % b;

            a = temp;
        }

        return String.valueOf(a);
    }
}
