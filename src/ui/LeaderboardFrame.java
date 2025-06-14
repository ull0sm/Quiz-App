package ui;

import dao.AttemptDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Map;

public class LeaderboardFrame extends JFrame {
    public LeaderboardFrame() {
        setTitle("Leaderboard");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // center the frame on screen

        // Add window listener to return to dashboard
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose();
                new DashboardFrame("user");
            }
        });

        JLabel label = new JLabel("Top Performers");
        label.setBounds(20, 10, 300, 30);
        add(label);

        String[] columns = { "Username", "Total Score" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        Map<String, Integer> leaderboard = AttemptDAO.getLeaderboard();
        leaderboard.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry -> model.addRow(new Object[] { entry.getKey(), entry.getValue() }));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 450, 180);
        add(scrollPane);

        setVisible(true);
    }
}
