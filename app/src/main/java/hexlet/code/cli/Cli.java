package hexlet.code.cli;

import java.util.Scanner;

public class Cli {
    private static Scanner scanner;

    public static Scanner getScanner() {
        if (Cli.scanner == null) {
            Cli.scanner = new Scanner(System.in);
        }
        return Cli.scanner;
    }

    public static void printOnSameLine(String msg) {
        System.out.print(msg);
    }

    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static int getInt() {
        return Cli.getScanner().nextInt();
    }

    public static String getString() {
        return Cli.getScanner().next();
    }

    public static void close() {
        Cli.getScanner().close();
    }
}
