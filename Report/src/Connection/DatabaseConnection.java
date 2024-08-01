//package Connection;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.DriverManager;
//
//public class DatabaseConnection {
//
//    private static DatabaseConnection instance;
//    private Connection connection;
//
//    public static DatabaseConnection getInstance() {
//        if (instance == null) {
//            instance = new DatabaseConnection();
//        }
//        return instance;
//    }
//
//    public void connecToDatabase() throws SQLException {
//
//        String server = "localhost";
//        String database = "fsms-data";
//        String username = "root";
//        String password = "Lhd1234";
//        String Port = "3307";
////        String server = "DS-SVR-PC";
////        String database = "fsms-data";
////        String username = "PosUser";
////        String password = "MasterPos1212";
//
//        connection = DriverManager.getConnection("jdbc:mysql://" + server + ":" + Port + "/" + database, username, password);
//    }
//
//    public Connection getConnection() throws SQLException {
//        if (connection == null) {
//            connecToDatabase();
//        }
//        return connection;
//    }
//
//    public void setConnection(Connection connection) {
//        this.connection = connection;
//    }
//}
package Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() throws SQLException {
        connecToDatabase();
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private void connecToDatabase() throws SQLException {
//        String server = "FP-SERVER-PC";   
//        String server = "JANAKA-LAP";
       String server = "localhost";
        String database = "data";
        String username = "root";
        String password = "Lhd1234";
        String port = "3307";
//        String server = "DS-SVR-PC";
//        String database = "fsms-data";
//        String username = "PosUser";
//        String password = "MasterPos1212";

        connection = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, username, password);
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connecToDatabase();
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
