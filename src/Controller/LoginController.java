package Controller;

import Model.Login;
import Model.Mysql_Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginController {
     public List<Login> getLogin() throws SQLException {
        String sql = "SELECT * from login";
        List<Login> logins = new ArrayList<>();

        try (Connection connection = Mysql_Connection.getInstance().getConnection(); Statement statment = connection.createStatement(); ResultSet result = statment.executeQuery(sql)) {

            while (result.next()) {
                Login login = new Login();
                login.setUsername(result.getString("username"));
                login.setPassword(result.getString("password"));
                
                logins.add(login);
            }
        }
        return logins;
    }
}
