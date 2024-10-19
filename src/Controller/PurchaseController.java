package Controller;

import Model.Purchase;
import Model.Mysql_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Time;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class PurchaseController {

    public void savePurchase(Purchase purchase) throws Exception {
        String sql = "INSERT INTO grn (Supplier,subTotal,Add_Discount,Total,Date,Time)VALUES(?, ?, ?, ?, ?, ?)";

        try (Connection connection = Mysql_Connection.getInstance().getConnection(); PreparedStatement prstmt = connection.prepareStatement(sql)) {
            prstmt.setString(1, purchase.getSpplier());
            prstmt.setDouble(2, purchase.getSubTotal());
            prstmt.setDouble(3, purchase.getAdd_Discount());
            prstmt.setDouble(4, purchase.getTotal());
            prstmt.setDate(5, Date.valueOf(purchase.getDate()));
            prstmt.setTime(6, Time.valueOf(purchase.getTime()));
            int insertedRow = prstmt.executeUpdate();

            if (insertedRow > 0) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/success.png"));
                JOptionPane.showMessageDialog(null, "A new Fuel was inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"));
                JOptionPane.showMessageDialog(null, "A new Fuel was inserted Failed!", "Failed", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        } catch (Exception e) {
        }

    }
}
