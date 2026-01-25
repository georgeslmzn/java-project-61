package hexlet.code.games;

import hexlet.code.cli.Cli;

public class Greet {
    public static String getName() {
        Cli.printMsg("Welcome to the Brain Games!");
        Cli.printMsg("May I have your name?");
        return Cli.getString();
    }

    public static void run() {
        Cli.printMsg("Welcome to the Brain Games!");
        Cli.printMsg("May I have your name?");
        String name = Cli.getString();
        Cli.printMsg("Hello, " + name + "!");
    }
}
