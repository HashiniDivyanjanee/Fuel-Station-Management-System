/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    
    public static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
//   private  DatabaseConnection(){
//       
//   }
    
   public void connecToDatabase() throws SQLException{
       String server = "localhost";
       String Port = "3307";
       String database = "fsms-data";
       String username ="PosUser";
       String password = "MasterPos1212";
       connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+Port+"/"+database,username,password);
       
   }
public Connection getConnection(){
    return connection;
}

public void setConnection(Connection connection){
    this.connection=connection;
   
}
 
}
