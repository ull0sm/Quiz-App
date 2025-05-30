package ui;

import dao.AttemptDAO;
import model.Attempt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ResultsFrame extends JFrame {
    public ResultsFrame(String username) {
        setTitle("Quiz Results");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);

        // Add window listener to return to dashboard
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new DashboardFrame(username);
            }
        });

        JLabel label = new JLabel("Results for: " + username);
        label.setBounds(20, 10, 300, 30);
        add(label);

        String[] columns = {"Quiz", "Score"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        List<Attempt> attempts = AttemptDAO.getAttemptsByUser(username);
        for (Attempt a : attempts) {
            model.addRow(new Object[]{a.getQuiz(), a.getScore()});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 450, 180);
        add(scrollPane);

        setVisible(true);
    }
}