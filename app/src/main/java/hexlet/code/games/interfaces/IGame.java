package hexlet.code.games.interfaces;

public interface IGame {
    void explainRules();

    String getQuestion();

    String getCorrectAnswer(String question);
}
