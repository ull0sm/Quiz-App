package model;

public class Question {
    private int id;
    private String quiz;
    private String text;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;

    public Question(int id, String quiz, String text, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        this.id = id;
        this.quiz = quiz;
        this.text = text;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
    }

    public int getId() {
        return id;
    }

    public String getQuiz() {
        return quiz;
    }

    public String getText() {
        return text;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }
}