package model;

public class Attempt {
    private String username;
    private String quiz;
    private int score;

    public Attempt(String username, String quiz, int score) {
        this.username = username;
        this.quiz = quiz;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public String getQuiz() {
        return quiz;
    }

    public int getScore() {
        return score;
    }
}