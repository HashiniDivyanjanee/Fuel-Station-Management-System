package Controller;

import Model.Mysql_Connection;
import Model.Fuel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class FuelController {

    public void saveFuel(Fuel fuel) throws SQLException {
        String sql = "INSERT INTO fuel (FuelName, CostPrice, SalePrice, TankID, Liter) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = Mysql_Connection.getInstance().getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, fuel.getFluelName());
            pstmt.setDouble(2, fuel.getCostPrice());
            pstmt.setDouble(3, fuel.getSalePrice());
            pstmt.setString(4, fuel.getTankID());
            pstmt.setDouble(5, fuel.getLiter());           
            
           int rowsInserted = pstmt.executeUpdate();

                if (rowsInserted > 0) {
                    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/success.png"));
                    JOptionPane.showMessageDialog(null, "A new Fuel was inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
                    
                }else{
                    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"));
                    JOptionPane.showMessageDialog(null, "A new Fuel was inserted Failed!", "Failed", JOptionPane.INFORMATION_MESSAGE, icon);
                }     
        }   
    }
    
    
    
 public List<Fuel> getAllFuel() throws SQLException {
    String sql = "SELECT * FROM fuel";
    List<Fuel> fuelList = new ArrayList<>();
    
    try (Connection connection = Mysql_Connection.getInstance().getConnection(); 
         Statement statement = connection.createStatement(); 
         ResultSet resultSet = statement.executeQuery(sql)) {
        
        while (resultSet.next()) {
            Fuel fuel = new Fuel(resultSet.getString("FuelName"), 
                                 resultSet.getDouble("CostPrice"), 
                                 resultSet.getDouble("SalePrice"), 
                                 resultSet.getString("TankID"), 
                                 resultSet.getDouble("Liter"));
            fuel.setFuelID(resultSet.getInt("fid"));
            fuelList.add(fuel);
        }
    }
    
    return fuelList;
}


}