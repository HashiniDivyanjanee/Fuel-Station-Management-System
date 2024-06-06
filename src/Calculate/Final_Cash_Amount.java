package Calculate;

import DBConnection.Mysql_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Final_Cash_Amount {

    public static double[] calc(double start, double end, double price, double cash) {
        double[] literAmount = new double[3];

        literAmount[0] = end - start;
        literAmount[1] = (end - start) * price;
        literAmount[2] = literAmount[1]-cash;
        return literAmount;
    }

    public static double getPriceFromDatabase(String tank) {
        double price = 0.0;
        String query = "SELECT SalePrice FROM fuel WHERE TRIM(LOWER(TankID)) = LOWER(?)";

        try (Connection conn = Mysql_Connection.getInstance().getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tank.trim());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("SalePrice");

            } else {
                System.out.println("No price found for tank: " + tank);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        return price;
    }
}
