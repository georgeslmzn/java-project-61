package hexlet.code.games;

public interface IGame {
    String getQuestion();

    String getCorrectAnswer(String question);

    void explainRules();
}
