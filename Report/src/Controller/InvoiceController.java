package Controller;
import Model.Database;
import Model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvoiceController {
   
    public void saveInvoice(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO invoice (amount, customer_id) VALUES (?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, invoice.getAmount());
            statement.setInt(2, invoice.getCustomerId());
            statement.executeUpdate();
        }
    } 
}
