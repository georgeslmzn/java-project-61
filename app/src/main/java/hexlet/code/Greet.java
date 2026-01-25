package hexlet.code;

import hexlet.code.cli.Cli;

public class Greet {
    private static String name;

    public static String getName() {
        return Greet.name;
    }

    public static void run() {
        Cli.printMsg("Welcome to the Brain Games!");
        Cli.printMsgOnTheSameLine("May I have your name? ");
        Greet.name = Cli.getInput();
        Cli.printMsg("Hello, " + name + "!");
    }
}
