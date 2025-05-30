package dao;

import util.DBConnection;
import java.sql.*;

public class UserDAO {
    public static boolean registerUser(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean isUserExists(String username) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean validateUser(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
