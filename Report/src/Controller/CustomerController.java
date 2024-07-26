
package Controller;
import Model.Customer;
import Model.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CustomerController {
      public int saveCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int customerId = generatedKeys.getInt(1);
                customer.setId(customerId);
                return customerId;
            } else {
                throw new SQLException("Creating customer failed, no ID obtained.");
            }
        }
    }
}
