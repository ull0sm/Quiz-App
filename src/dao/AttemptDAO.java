package dao;

import model.Attempt;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class AttemptDAO {
    public static void saveAttempt(String username, String quizName, int score) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO attempts (username, quiz, score) VALUES (?, ?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, quizName);
            stmt.setInt(3, score);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Attempt> getAttemptsByUser(String username) {
        List<Attempt> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT quiz, score FROM attempts WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Attempt(username, rs.getString("quiz"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<String, Integer> getLeaderboard() {
        Map<String, Integer> map = new HashMap<>();
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT username, SUM(score) as total FROM attempts GROUP BY username");
            while (rs.next()) {
                map.put(rs.getString("username"), rs.getInt("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }
}
