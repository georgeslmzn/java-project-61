package hexlet.code;

import hexlet.code.cli.Cli;
import hexlet.code.games.Calc;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static String[][] games;

    public static final int OPTIONS_COUNT = 7;

    public static final int OPTIONS_DESCRIPTION_LENGTH = 2;

    public static final int INDEX_OF_EXIT = 0;

    public static final int INDEX_OF_GREET = 1;

    public static final int INDEX_OF_EVEN = 2;

    public static final int INDEX_OF_CALC = 3;

    public static final int INDEX_OF_GCD = 4;

    public static final int INDEX_OF_PROGRESSION = 5;

    public static final int INDEX_OF_PRIME = 6;

    public static void setGames() {
        App.games = new String[App.OPTIONS_COUNT][App.OPTIONS_DESCRIPTION_LENGTH];

        for (int i = 0; i < App.games.length; i++) {
            App.games[i][0] = String.valueOf(i);

            if (i == App.INDEX_OF_EXIT) {
                App.games[i][1] = "Exit";
            } else if (i == App.INDEX_OF_GREET) {
                App.games[i][1] = "Greet";
            } else if (i == App.INDEX_OF_EVEN) {
                App.games[i][1] = "Even";
            } else if (i == App.INDEX_OF_CALC) {
                App.games[i][1] = "Calc";
            } else if (i == App.INDEX_OF_GCD) {
                App.games[i][1] = "GCD";
            } else if (i == App.INDEX_OF_PROGRESSION) {
                App.games[i][1] = "Progression";
            } else if (i == App.INDEX_OF_PRIME) {
                App.games[i][1] = "Prime";
            }
        }
    }

    public static int choseGame() {
        Cli.printMsg("Please enter the game number and press Enter.");

        for (String[] game : App.games) {
            Cli.printMsg(game[0] + " - " + game[1]);
        }

        int chosenGameNumber = App.getGameNumber();
        Cli.printMsg("");

        return chosenGameNumber;
    }

    private static int getGameNumber() {
        Cli.printOnSameLine("Your choice: ");
        return Cli.getInt();
    }

    public static void main(String[] args) {
        App.setGames();

        int chosenGameNumber = App.choseGame();

        if (chosenGameNumber == App.INDEX_OF_EXIT) {
            Exit.run();
        } else if (chosenGameNumber == App.INDEX_OF_GREET) {
            Greet.run();
        } else if (chosenGameNumber == App.INDEX_OF_EVEN) {
            Engine.run(new EvenGame());
        } else if (chosenGameNumber == App.INDEX_OF_CALC) {
            Engine.run(new Calc());
        } else if (chosenGameNumber == App.INDEX_OF_GCD) {
            Engine.run(new GCD());
        } else if (chosenGameNumber == App.INDEX_OF_PROGRESSION) {
            Engine.run(new Progression());
        } else if (chosenGameNumber == App.INDEX_OF_PRIME) {
            Engine.run(new Prime());
        }
    }
}
