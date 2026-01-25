package hexlet.code;

import hexlet.code.cli.Cli;
import hexlet.code.games.GamesStorage;
import hexlet.code.games.interfaces.IGame;

public class App {
    private static final String EXIT_CODE = "0";

    private static final String GREET_CODE = "1";

    public static void main(String[] args) {
        String actionCode = App.getActionCode();
        Cli.printMsg("");

        if (actionCode.equals(App.EXIT_CODE)) {
            Engine.exit();
        }

        if (actionCode.equals(App.GREET_CODE)) {
            Engine.greet();
        }

        IGame game = GamesStorage.getGame(actionCode);
        if (game != null) {
            Engine.play(game);
        }

        Engine.exit();
    }

    public static void printActions() {
        Cli.printMsg("Please enter the game number and press Enter.");

        Cli.printMsg("1 - Greet");
        for (String[] game : GamesStorage.getGamesMap()) {
            Cli.printMsg(game[0] + " - " + game[1]);
        }
        Cli.printMsg("0 - Exit");

        Cli.printMsgOnTheSameLine("Your choice: ");
    }

    private static String getActionCode() {
        App.printActions();

        return Cli.getInput();
    }
}
