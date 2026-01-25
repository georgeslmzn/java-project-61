package hexlet.code.games;

import hexlet.code.Randomize;
import hexlet.code.cli.Cli;

public final class Prime implements IGame {
    private String correctAnswer;

    public void explainRules() {
        Cli.printMsg("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public String getQuestion() {
        final int min = 0;
        final int max = 1000;

        int question = Randomize.getRandom(min, max);

        if (this.isPrime(question)) {
            this.correctAnswer = "yes";
        } else {
            this.correctAnswer = "no";
        }

        return String.valueOf(question);
    }

    public String getCorrectAnswer(String question) {
        return this.correctAnswer;
    }

    private boolean isPrime(int n) {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int five = 5;
        final int six = 6;

        // Простые числа > 1
        if (n <= one) {
            return false;
        }
        // 2 и 3 - простые числа
        if (n <= three) {
            return true;
        }
        // Делимость на 2 или 3
        if (n % two == 0 || n % three == 0) {
            return false;
        }

        boolean isPrime = true;
        // Проверка делителей до sqrt(n), перебор через 6k +/- 1
        for (int i = five; i * i <= n; i += six) {
            if (n % i == 0 || n % (i + two) == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
