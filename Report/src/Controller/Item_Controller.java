package Controller;

import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import Model.Item;
import java.util.ArrayList;

public class Item_Controller {   
    public List<Item> getItem() throws SQLException{
        String sql = "SELECT DISTINCT `Cat_Name` FROM `items` ORDER BY `Cat_Name` ASC;";
        List<Item> categories = new ArrayList<>();        
          try (Connection connection = DatabaseConnection.getInstance().getConnection(); Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)){            
            while(result.next()){
                Item ctgry = new Item();
                ctgry.setCategory(result.getString("Cat_Name"));
                categories.add(ctgry);
            }            
        } catch (Exception e) {
              e.printStackTrace();       
               throw new SQLException("Error while retrieving categories", e);
        }       
        return categories;
    }
}