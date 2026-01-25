package hexlet.code.games;

import hexlet.code.games.interfaces.IGame;

public class GamesStorage {
    private static final String EVEN_CODE = "2";

    private static final String CALC_CODE = "3";

    private static final String GCD_CODE = "4";

    private static final String PROGRESSION_CODE = "5";

    private static final String PRIME_CODE = "6";

    public static String[][] getGamesMap() {
        return new String[][]{
           {EVEN_CODE, "Even"},
           {CALC_CODE, "Calc"},
           {GCD_CODE, "GCD"},
           {PROGRESSION_CODE, "Progression"},
           {PRIME_CODE, "Prime"},
        };
    }

    public static IGame getGame(String gameCode) {
        return switch (gameCode) {
            case GamesStorage.EVEN_CODE -> new EvenGame();
            case GamesStorage.CALC_CODE -> new Calc();
            case GamesStorage.GCD_CODE -> new GCD();
            case GamesStorage.PROGRESSION_CODE -> new Progression();
            case GamesStorage.PRIME_CODE -> new Prime();
            default -> null;
        };

    }
}
