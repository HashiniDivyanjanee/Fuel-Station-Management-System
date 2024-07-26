package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
     private static final String DB_URL = "jdbc:mysql://localhost:3307/sales";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Lhd1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
