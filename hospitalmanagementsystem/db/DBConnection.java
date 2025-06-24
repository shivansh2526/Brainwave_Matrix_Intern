package db;

import java.sql.*;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", ""); // Add password if any
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
