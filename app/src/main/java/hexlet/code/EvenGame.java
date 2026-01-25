package hexlet.code;

import java.lang.Math;

public class EvenGame {
    private static final int max = 1000;

    private static final int min = 0;

    private static final String yes = "yes";

    private static final String no = "no";

    private static final int correctCountForWin = 3;

    private static String gamerName;

    public static void run(String userName) {
        EvenGame.gamerName = userName;
        Cli.printMsg("Hello," + EvenGame.gamerName + "!");
        Cli.printMsg("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctCount = 0;
        do {
            int num  = EvenGame.generateNumber();
            EvenGame.askQuestion(num);
            String answer = Cli.getString();

            if (EvenGame.isEven(num)) {
                if (answer.equals(EvenGame.yes)) {
                    correctCount++;
                    correctMessage();
                } else {
                    loseMessage("'" + answer + "'", "'" + EvenGame.yes + "'");
                    return;
                }
            } else {
                if (answer.equals(EvenGame.no)) {
                    correctCount++;
                    correctMessage();
                } else {
                    loseMessage("'" + answer + "'", "'" +  EvenGame.no + "'");
                    return;
                }
            }

        } while (correctCount < EvenGame.correctCountForWin);

        winMessage();
    }

    private static int generateNumber() {
        int range = (EvenGame.max - EvenGame.min) + 1;
        return (int) ((range  * Math.random()) + min);
    }

    private static void askQuestion(int num) {
        Cli.printMsg("Question: " + num);
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static void correctMessage() {
        Cli.printMsg("Correct!");
    }

    private static void winMessage() {
        Cli.printMsg("Congratulations, " + EvenGame.gamerName + "!");
    }

    private static void loseMessage(String userAnswer, String correctAnswer) {
        Cli.printMsg(userAnswer + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
        Cli.printMsg("Let's try again, " + EvenGame.gamerName);
    }
}
