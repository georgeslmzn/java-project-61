package hexlet.code;

public class App {
    public static String[][] games;

    public static void setGames() {
        App.games = new String[3][2];

        App.games[0][0] = "0";
        App.games[0][1] = "Exit";

        App.games[1][0] = "1";
        App.games[1][1] = "Greet";

        App.games[2][0] = "2";
        App.games[2][1] = "Even";
    }

    public static int choseGame() {
        Cli.printMsg("Please enter the game number and press Enter.");

        for (String[] game : App.games) {
            Cli.printMsg(game[0] + " - " + game[1]);
        }

        int chosenGameNumber = Cli.getInt();

        Cli.printMsg("Your choice: " + chosenGameNumber);

        return chosenGameNumber;
    }

    public static void main(String[] args) {
        App.setGames();
        String gamerName = Greet.getName();

        int chosenGameNumber = 0;
        do {
            chosenGameNumber = App.choseGame();

            if (chosenGameNumber == 0) {
                Exit.run();
                continue;
            }

            if (chosenGameNumber == 1) {
                Greet.run();
                continue;
            }

            if (chosenGameNumber == 2) {
                EvenGame.run(gamerName);
            }
        } while (chosenGameNumber != 0);
    }
}
