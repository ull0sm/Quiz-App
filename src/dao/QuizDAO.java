package dao;

import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {
    public static List<String> getAllQuizzes() {
        List<String> quizzes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM quizzes");
            while (rs.next()) {
                quizzes.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }
}