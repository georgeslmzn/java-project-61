package hexlet.code;

import hexlet.code.cli.Cli;
import hexlet.code.games.interfaces.IGame;

class Engine {
    private static final int ANSWERS_COUNT_FOR_WIN = 3;

    public static void play(IGame game) {
        Engine.greet();

        game.explainRules();

        int correctCount = 0;
        String correctAnswer;
        String userAnswer;
        do {
            String question = game.getQuestion();
            Engine.askQuestion(question);

            correctAnswer = game.getCorrectAnswer(question);
            userAnswer = Engine.getUserAnswer();

            if (userAnswer.equals(correctAnswer)) {
                correctCount++;
                Engine.sayCorrect();
            } else {
                break;
            }
        } while (correctCount < Engine.ANSWERS_COUNT_FOR_WIN);

        if (correctCount == Engine.ANSWERS_COUNT_FOR_WIN) {
            Engine.win();
        } else {
            Engine.lose(userAnswer, correctAnswer);
        }

        Engine.exit();
    }

    public static void exit() {
        Exit.run();
    }

    public static void greet() {
        Greet.run();
    }

    public static String getUserAnswer() {
        Cli.printMsgOnTheSameLine("Your answer: ");
        return Cli.getInput();
    }

    public static void askQuestion(String question) {
        Cli.printMsg("Question: " + question);
    }

    public static void sayCorrect() {
        Cli.printMsg("Correct!");
    }

    public static void win() {
        Cli.printMsg("Congratulations, " + Greet.getName() + "!");
    }

    public static void lose(String userAnswer, String correctAnswer) {
        Cli.printMsg("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'.");
        Cli.printMsg("Let's try again, " + Greet.getName() + "!");
        Cli.printMsg("");
    }
}
