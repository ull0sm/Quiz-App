package ui;

import dao.QuestionDAO;
import dao.AttemptDAO;
import model.Question;
import model.UserAnswer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class QuizPlayFrame extends JFrame {
    private String username, quizName;
    private List<Question> questions;
    private List<UserAnswer> userAnswers;
    private int currentIndex = 0;

    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup group;
    private JButton nextButton, backButton, submitButton;

    public QuizPlayFrame(String username, String quizName) {
        this.username = username;
        this.quizName = quizName;
        questions = QuestionDAO.getQuestionsByQuiz(quizName);
        userAnswers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++)
            userAnswers.add(null);

        setTitle("Quiz - " + quizName);
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // center the frame on screen

        questionLabel = new JLabel();
        questionLabel.setBounds(30, 20, 440, 30);
        add(questionLabel);

        options = new JRadioButton[4];
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBounds(50, 60 + i * 30, 400, 30);
            group.add(options[i]);
            add(options[i]);
        }

        backButton = new JButton("Back");
        backButton.setBounds(100, 200, 80, 30);
        add(backButton);

        nextButton = new JButton("Next");
        nextButton.setBounds(200, 200, 80, 30);
        add(nextButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(300, 200, 100, 30);
        add(submitButton);

        loadQuestion();

        nextButton.addActionListener((ActionEvent e) -> {
            saveAnswer();
            if (currentIndex < questions.size() - 1) {
                currentIndex++;
                loadQuestion();
            }
        });

        backButton.addActionListener((ActionEvent e) -> {
            saveAnswer();
            if (currentIndex > 0) {
                currentIndex--;
                loadQuestion();
            }
        });

        submitButton.addActionListener((ActionEvent e) -> {
            saveAnswer();
            int score = 0;
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                UserAnswer ua = userAnswers.get(i);
                if (ua != null && ua.getSelectedOption().equals(q.getCorrectOption())) {
                    score++;
                }
            }
            AttemptDAO.saveAttempt(username, quizName, score);
            JOptionPane.showMessageDialog(null, "Quiz submitted! Score: " + score);
            dispose();
            new DashboardFrame(username);
        });

        setVisible(true);
    }

    private void loadQuestion() {
        Question q = questions.get(currentIndex);
        questionLabel.setText("Q" + (currentIndex + 1) + ": " + q.getText());
        group.clearSelection();
        options[0].setText(q.getOptionA());
        options[1].setText(q.getOptionB());
        options[2].setText(q.getOptionC());
        options[3].setText(q.getOptionD());
        for (int i = 0; i < 4; i++) {
            options[i].setSelected(false);
        }
        UserAnswer ua = userAnswers.get(currentIndex);
        if (ua != null) {
            for (int i = 0; i < 4; i++) {
                if (q.getOptionA().equals(ua.getSelectedOption())) {
                    options[i].setSelected(true);
                    break;
                }
            }
        }
    }

    private void saveAnswer() {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                char optionLetter = (char) ('A' + i); // Convert index to A, B, C, D
                userAnswers.set(currentIndex,
                        new UserAnswer(questions.get(currentIndex).getId(), String.valueOf(optionLetter)));
                break;
            }
        }
    }
}
