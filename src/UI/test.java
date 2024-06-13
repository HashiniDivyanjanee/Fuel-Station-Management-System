
package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/sales";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Lhd1234";

    public static void main(String[] args) {
        try {
            // 1. Connect to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // 2. Create a new customer
            String customerName = "Hashini";
            String customerEmail = "john.doe@example.com";
            int customerId = saveCustomer(connection, customerName, customerEmail);

            // 3. Create a new invoice for the customer
            double invoiceAmount = 250.75;
            saveInvoice(connection, invoiceAmount, customerId);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int saveCustomer(Connection connection, String name, String email) throws SQLException {
        String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.executeUpdate();

        // Get the generated customer ID
        java.sql.ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        } else {
            throw new SQLException("Creating customer failed, no ID obtained.");
        }
    }

    private static void saveInvoice(Connection connection, double amount, int customerId) throws SQLException {
        String sql = "INSERT INTO invoice (amount, customer_id) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, amount);
        statement.setInt(2, customerId);
        statement.executeUpdate();
    }
}
