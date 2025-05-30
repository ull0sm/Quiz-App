package model;

public class UserAnswer {
    private int questionId;
    private String selectedOption;

    public UserAnswer(int questionId, String selectedOption) {
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getSelectedOption() {
        return selectedOption;
    }
}
