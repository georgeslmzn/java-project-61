package hexlet.code.cli;

import java.util.Scanner;

public class Cli {
    private static Scanner scanner;

    public static Scanner getScanner() {
        if (Cli.scanner == null) {
            Cli.scanner = new Scanner(System.in);
        }

        return new Scanner(System.in);
    }

    public static void printMsgOnTheSameLine(String msg) {
        System.out.print(msg);
    }

    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static String getInput() {
        return Cli.getScanner().next();
    }

    public static void close() {
        Cli.getScanner().close();
    }
}
