package Controller;

import Model.Employee;
import Model.Mysql_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class EmployeeController {

    public void saveEmployee(Employee employee) throws Exception {
        String sql = "INSERT INTO employee (FirstName, LastName, Address, Nic, Gender, Dob, Mobile, LandlineNumber, Email, Bank, Branch, AccNumber, holderName, Salary, Position, HireDate, EmployeeType, Schedule) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = Mysql_Connection.getInstance().getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, employee.getFname());
            pstmt.setString(2, employee.getLname());
            pstmt.setString(3, employee.getAddress());
            pstmt.setString(4, employee.getNic());
            pstmt.setString(5, employee.getGender());
            pstmt.setString(6, employee.getDob());
            pstmt.setInt(7, employee.getMobile());
            pstmt.setInt(8, employee.getLand());
            pstmt.setString(9, employee.getEmail());
            pstmt.setString(10, employee.getBank());
            pstmt.setString(11, employee.getBranch());
            pstmt.setInt(12, employee.getAcc());
            pstmt.setString(13, employee.getHolder());
            pstmt.setDouble(14, employee.getSalary());
            pstmt.setString(15, employee.getPosition());
            pstmt.setString(16, employee.getHire());
            pstmt.setString(17, employee.getEmpType());
            pstmt.setString(18, employee.getSchedule());

            int insertedRow = pstmt.executeUpdate();

            if (insertedRow > 0) {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/success.png"));
                JOptionPane.showMessageDialog(null, "A new Fuel was inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                Icon icon = new javax.swing.ImageIcon(getClass().getResource("/Icon/error.png"));
                JOptionPane.showMessageDialog(null, "A new Fuel was inserted Failed!", "Failed", JOptionPane.INFORMATION_MESSAGE, icon);
            }

        } catch (Exception e) {
             e.printStackTrace();
        }

    }

}
