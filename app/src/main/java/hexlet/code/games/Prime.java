package hexlet.code.games;

import hexlet.code.Randomize;
import hexlet.code.cli.Cli;

public class Prime implements IGame {
    private String correctAnswer;

    public void explainRules() {
        Cli.printMsg("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public String getQuestion() {
        int min = 0;
        int max = 1000;

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
        // Простые числа > 1
        if (n <= 1) {
            return false;
        }
        // 2 и 3 - простые числа
        if (n <= 3) {
            return true;
        }
        // Делимость на 2 или 3
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Проверка делителей до sqrt(n), перебор через 6k +/- 1
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

}
