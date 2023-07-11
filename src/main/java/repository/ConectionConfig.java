package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/AIRLINE";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }
}
