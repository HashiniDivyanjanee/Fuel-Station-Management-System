package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql_Connection {
    private static Mysql_Connection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3307/fuel";
    private String username = "root";
    private String password = "Lhd1234";

    private Mysql_Connection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Mysql_Connection getInstance() throws SQLException {
        if (instance == null) {
            instance = new Mysql_Connection();
        } else if (instance.getConnection().isClosed()) {
            instance = new Mysql_Connection();
        }

        return instance;
    }
}
