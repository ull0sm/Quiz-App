package util;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/quiz_app";
    private static final String USER = "root";
    private static final String PASSWORD = "simp";
    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conn;
    }
}