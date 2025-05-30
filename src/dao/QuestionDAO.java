package dao;

import model.Question;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    public static List<Question> getQuestionsByQuiz(String quizName) {
        List<Question> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT id, quiz, text, optionA, optionB, optionC, optionD, correctOption FROM questions WHERE quiz = ?");
            stmt.setString(1, quizName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Question(
                    rs.getInt("id"),
                    rs.getString("quiz"),
                    rs.getString("text"),
                    rs.getString("optionA"),
                    rs.getString("optionB"),
                    rs.getString("optionC"),
                    rs.getString("optionD"),
                    rs.getString("correctOption")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching questions: " + e.getMessage());
        }
        return list;
    }

    public static boolean addQuestion(Question question) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO questions (quiz, text, optionA, optionB, optionC, optionD, correctOption) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, question.getQuiz());
            stmt.setString(2, question.getText());
            stmt.setString(3, question.getOptionA());
            stmt.setString(4, question.getOptionB());
            stmt.setString(5, question.getOptionC());
            stmt.setString(6, question.getOptionD());
            stmt.setString(7, question.getCorrectOption());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding question: " + e.getMessage());
        }
    }
}
