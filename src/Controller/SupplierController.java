package Controller;

import Model.Customer;
import Model.Supplier;
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

public class SupplierController {

    public void saveSupplier(Supplier supplier) throws Exception {
        String sql = "INSERT INTO supplier(Company, Supplier_Name, Title, Address, Mobile, Landline, Fax, Email, Website, Bank, Branch, Acc, Holder, Opening_Amount, Limit_Amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        
        try (Connection connection = Mysql_Connection.getInstance().getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, supplier.getCompany());
            pstmt.setString(2, supplier.getSupplier_Name());
            pstmt.setString(3, supplier.getTitle());
            pstmt.setString(4, supplier.getAddress());
            pstmt.setInt(5, supplier.getMobile());
            pstmt.setInt(6, supplier.getLandline());
            pstmt.setInt(7, supplier.getFax());
            pstmt.setString(8, supplier.getEmail());
            pstmt.setString(9, supplier.getWebsite());
            pstmt.setString(10, supplier.getBank());
            pstmt.setString(11, supplier.getBranch());
            pstmt.setInt(12, supplier.getAcc());
            pstmt.setString(13, supplier.getHolder());
            pstmt.setDouble(14, supplier.getOpening_Amount());
            pstmt.setDouble(15, supplier.getLimit_Amount());
            int rowInserted = pstmt.executeUpdate();

            if (rowInserted > 0) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/success.png"));
                JOptionPane.showMessageDialog(null, "A new Supplier was inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, icon);

            } else {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"));
                JOptionPane.showMessageDialog(null, "A new Supplier was inserted Failed!", "Failed", JOptionPane.INFORMATION_MESSAGE, icon);
            }

        } catch (Exception e) {
              e.printStackTrace();
        }

    }
    
      public List<Supplier> getSupplier() throws SQLException {
        String sql = "SELECT * from supplier";
        List<Supplier> suppliers = new ArrayList<>();

        try (Connection connection = Mysql_Connection.getInstance().getConnection(); Statement statment = connection.createStatement(); ResultSet result = statment.executeQuery(sql)) {

            while (result.next()) {
                Supplier supplier = new Supplier();
//                supplier.setCid(result.getInt("cid"));
//                customer.setName(result.getString("Name"));
//                customer.setNic(result.getString("Nic"));
//                customer.setAddress(result.getString("Address"));
//                customer.setMobile(result.getInt("Mobile"));
//                customer.setFax(result.getInt("Fax"));
//                customer.setEmail(result.getString("Email"));
//                customer.setCardType(result.getString("CardType"));
//                customer.setCardNo(result.getInt("CardNo"));
//                customer.setExpireDate(result.getString("ExpireDate"));
//                customer.setCvv(result.getInt("Cvv"));
//                customer.setVehicleNo(result.getString("VehicleNo"));
//                customer.setVehicleType(result.getString("VehicleType"));
//                customer.setFuelType(result.getString("FuelType"));
                suppliers.add(supplier);
            }
        }
        return suppliers;
    }
    

}
