package hexlet.code.games;

public interface IGame {
    void explainRules();

    String getQuestion();

    String getCorrectAnswer(String question);
}
