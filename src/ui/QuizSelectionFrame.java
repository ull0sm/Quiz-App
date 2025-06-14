package ui;

import dao.QuizDAO;
import model.Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class QuizSelectionFrame extends JFrame {
    private JComboBox<String> quizComboBox;
    private JButton startButton;
    private String username;

    public QuizSelectionFrame(String username) {
        this.username = username;
        setTitle("Select Quiz");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // center the frame on screen

        JLabel label = new JLabel("Choose a Quiz:");
        label.setBounds(50, 40, 120, 30);
        add(label);

        quizComboBox = new JComboBox<>();
        quizComboBox.setBounds(170, 40, 150, 30);
        List<String> quizNames = QuizDAO.getAllQuizzes();
        for (String quizName : quizNames) {
            quizComboBox.addItem(quizName);
        }
        quizComboBox.setBounds(170, 40, 150, 30);
        add(quizComboBox);

        startButton = new JButton("Start Quiz");
        startButton.setBounds(130, 100, 120, 30);
        add(startButton);

        startButton.addActionListener((ActionEvent e) -> {
            String quizName = (String) quizComboBox.getSelectedItem();
            dispose();
            new QuizPlayFrame(username, quizName);
        });

        setVisible(true);
    }
}