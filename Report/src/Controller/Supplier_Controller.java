package Controller;

import Model.Supplier;
import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

public class Supplier_Controller {
    public List<Supplier> getSupplier()throws SQLException{
        
        String sql = "SELECT DISTINCT `Supp_Name` FROM `supplier` ORDER BY `Supp_Name` ASC;";
        List <Supplier> suppliers = new ArrayList<>();
        
        try (Connection connection = DatabaseConnection.getInstance().getConnection(); Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)){
            
            while(result.next()){
                Supplier supp = new Supplier();
                supp.setSupp_Name(result.getString("Supp_Name"));
                suppliers.add(supp);
            }           
        } catch (Exception e) {
            
        }
        return suppliers;       
    };
}
