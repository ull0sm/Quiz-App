package ui;

import dao.UserDAO;


import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;

    public RegisterFrame() {
        setTitle("Register");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        submitButton = new JButton("Register");
        panel.add(new JLabel());
        panel.add(submitButton);

        add(panel);

        submitButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username and password", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                if (UserDAO.isUserExists(username)) {
                    JOptionPane.showMessageDialog(this, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    UserDAO.registerUser(username, password);
                    JOptionPane.showMessageDialog(this, "Registration successful! Please login.");
                    this.dispose();
                    new LoginFrame();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error registering user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
