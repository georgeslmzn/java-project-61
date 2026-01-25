package hexlet.code;

public class Randomize {
    public static int getRandom(int min, int max) {
        return (int) ((((max - min) + 1) * Math.random()) + min);
    }
}
