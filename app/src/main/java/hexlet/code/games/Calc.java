package hexlet.code.games;

import hexlet.code.Randomize;
import hexlet.code.cli.Cli;

public class Calc implements IGame {
    private int num1;

    private int num2;

    private char sign;

    public void explainRules() {
        Cli.printMsg("What is the result of the expression?");
    }

    public String getQuestion() {
        this.setSign();
        this.setNumbers();

        return this.num1 + " " + this.sign + " " + this.num2;
    }

    @Override
    public String getCorrectAnswer(String question) {
        if (this.sign == '+') {
            return String.valueOf(this.addNumbers());
        }

        if (this.sign == '-') {
            return String.valueOf(this.substractNumbers());
        }

        if (this.sign == '*') {
            return String.valueOf(this.multiplyNumbers());
        }

        return "";
    }

    private int addNumbers() {
        return this.num1 + this.num2;
    }

    private int multiplyNumbers() {
        return this.num1 * this.num2;
    }

    private int substractNumbers() {
        return this.num1 - this.num2;
    }

    private void setSign() {
        int min = 1;
        int max = 3;

        int random = Randomize.getRandom(min, max);
        if (random == 1) {
            this.sign = '+';
            return;
        }

        if (random == 2) {
            this.sign = '*';
            return;
        }

        if (random == 3) {
            this.sign = '-';
        }
    }

    private void setNumbers() {
        int min = 1;
        int max = 100;
        this.num1 = Randomize.getRandom(min, max);
        this.num2 = Randomize.getRandom(min,max);
    }
}
