package Controller;

import Model.Customer;
import Model.Mysql_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class CustomerController {

    public void saveCustomer(Customer customer) throws Exception {
        String sql = "INSERT INTO customer (Name, Nic, Address, Mobile, Landline, Fax, Email, CardType, CardNo, ExpireDate, Cvv, VehicleNo, VehicleType, FuelType) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = Mysql_Connection.getInstance().getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getNic());
            pstmt.setString(3, customer.getAddress());
            pstmt.setInt(4, customer.getMobile());
            pstmt.setInt(5, customer.getLandline());
            pstmt.setInt(6, customer.getFax());
            pstmt.setString(7, customer.getEmail());
            pstmt.setString(8, customer.getCardType());
            pstmt.setInt(9, customer.getCardNo());
            pstmt.setString(10, customer.getExpireDate());
            pstmt.setInt(11, customer.getCvv());
            pstmt.setString(12, customer.getVehicleNo());
            pstmt.setString(13, customer.getVehicleType());
            pstmt.setString(14, customer.getFuelType());

            int rowInserted = pstmt.executeUpdate();

            if (rowInserted > 0) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/success.png"));
                JOptionPane.showMessageDialog(null, "A new Fuel was inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"));
                JOptionPane.showMessageDialog(null, "A new Fuel was inserted Failed!", "Failed", JOptionPane.INFORMATION_MESSAGE, icon);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Customer> getCustomer() throws SQLException {
        String sql = "SELECT * from customer";
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = Mysql_Connection.getInstance().getConnection(); Statement statment = connection.createStatement(); ResultSet result = statment.executeQuery(sql)) {

            while (result.next()) {
                Customer customer = new Customer();
                customer.setCid(result.getInt("cid"));
                customer.setName(result.getString("Name"));
                customer.setNic(result.getString("Nic"));
                customer.setAddress(result.getString("Address"));
                customer.setMobile(result.getInt("Mobile"));
                customer.setFax(result.getInt("Fax"));
                customer.setEmail(result.getString("Email"));
                customer.setCardType(result.getString("CardType"));
                customer.setCardNo(result.getInt("CardNo"));
                customer.setExpireDate(result.getString("ExpireDate"));
                customer.setCvv(result.getInt("Cvv"));
                customer.setVehicleNo(result.getString("VehicleNo"));
                customer.setVehicleType(result.getString("VehicleType"));
                customer.setFuelType(result.getString("FuelType"));
                customers.add(customer);
            }
        }
        return customers;
    }

}
