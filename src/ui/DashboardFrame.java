package ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame(String username) {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + username);
        welcomeLabel.setBounds(30, 20, 300, 25);
        add(welcomeLabel);

        JButton playQuizBtn = new JButton("Play a Quiz");
        playQuizBtn.setBounds(100, 60, 200, 30);
        add(playQuizBtn);

        JButton resultsBtn = new JButton("Results");
        resultsBtn.setBounds(100, 110, 200, 30);
        add(resultsBtn);

        JButton leaderboardBtn = new JButton("Leaderboard");
        leaderboardBtn.setBounds(100, 160, 200, 30);
        add(leaderboardBtn);

        playQuizBtn.addActionListener(e -> {
            dispose();
            new QuizSelectionFrame(username);
        });

        resultsBtn.addActionListener(e -> {
            dispose();
            new ResultsFrame(username);
        });

        leaderboardBtn.addActionListener(e -> {
            dispose();
            new LeaderboardFrame();
        });

        setVisible(true);
    }
}
