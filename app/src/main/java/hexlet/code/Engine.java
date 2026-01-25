package hexlet.code;

import hexlet.code.cli.Cli;
import hexlet.code.games.IGame;

class Engine {
    public static String gamerName;

    public static final int WIN_COUNT = 3;

    public static void run(IGame game) {
        Engine.gamerName = Greet.getName();
        Engine.sayHello();

        game.explainRules();

        int correctCount = 0;
        boolean isLose = false;
        do {
            String question = game.getQuestion();
            Engine.askQuestion(question);

            String correctAnswer = game.getCorrectAnswer(question);
            String userAnswer = Engine.getUserAnswer();

            if (userAnswer.equals(correctAnswer)) {
                correctCount++;
                Engine.sayCorrect();
            } else {
                Engine.lose(userAnswer, correctAnswer);
                isLose = true;
            }
        } while (correctCount < Engine.WIN_COUNT && !isLose);

        if (isLose) {
            Exit.run();
            return;
        }

        Engine.win();
    }

    public static String getUserAnswer() {
        Cli.printOnSameLine("Your answer: ");
        return Cli.getString();
    }

    public static void sayHello() {
        Cli.printMsg("Hello, " + Engine.gamerName + "!");
    }

    public static void askQuestion(String question) {
        Cli.printMsg("Question: " + question);
    }

    public static void sayCorrect() {
        Cli.printMsg("Correct!");
    }

    public static void win() {
        Cli.printMsg("Congratulations, " + Engine.gamerName + "!");
    }

    public static void lose(String userAnswer, String correctAnswer) {
        Cli.printMsg("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was " + "'" + correctAnswer + "'.");
        Cli.printMsg("Let's try again, " + Engine.gamerName + "!");
        Cli.printMsg("");
    }
}
