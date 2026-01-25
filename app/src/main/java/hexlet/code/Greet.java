package hexlet.code;

import hexlet.code.cli.Cli;

public class Greet {
    public static String getName() {
        Cli.printMsg("Welcome to the Brain Games!");
        Cli.printMsg("May I have your name?");
        return Cli.getString();
    }

    public static void run() {
        String name = Greet.getName();
        Cli.printMsg("Hello, " + name + "!");
    }
}
