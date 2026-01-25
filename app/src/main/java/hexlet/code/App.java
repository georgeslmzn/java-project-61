package hexlet.code;

import hexlet.code.cli.Cli;
import hexlet.code.games.*;

public class App {
    public static String[][] games;

    public static void setGames() {
        App.games = new String[7][2];

        App.games[0][0] = "0";
        App.games[0][1] = "Exit";

        App.games[1][0] = "1";
        App.games[1][1] = "Greet";

        App.games[2][0] = "2";
        App.games[2][1] = "Even";

        App.games[3][0] = "3";
        App.games[3][1] = "Calc";

        App.games[4][0] = "4";
        App.games[4][1] = "GCD";

        App.games[5][0] = "5";
        App.games[5][1] = "Progresion";

        App.games[6][0] = "6";
        App.games[6][1] = "Prime";
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

        if (chosenGameNumber == 0) {
            Exit.run();
            return;
        }

        if (chosenGameNumber == 1) {
            Greet.run();
            return;
        }

        if (chosenGameNumber == 2) {
            Engine.run(new EvenGame());
            return;
        }

        if (chosenGameNumber == 3) {
            Engine.run(new Calc());
            return;
        }

        if (chosenGameNumber == 4) {
            Engine.run(new GCD());
            return;
        }

        if (chosenGameNumber == 5) {
            Engine.run(new Progression());
            return;
        }

        if (chosenGameNumber == 6) {
            Engine.run(new Prime());
        }
    }
}
