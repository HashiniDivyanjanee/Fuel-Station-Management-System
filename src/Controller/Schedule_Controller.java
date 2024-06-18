package Controller;

import Model.Shedule;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import Model.Mysql_Connection;
import java.sql.Connection;

public class Schedule_Controller {

    public List<Shedule> getAllSchedule() throws SQLException {
        String sql = "SELECT * FROM schedule WHERE Status ='Active'";
        List<Shedule> schedule = new ArrayList<>();

        try (Connection connection = Mysql_Connection.getInstance().getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Shedule shedule = new Shedule(resultSet.getString("pumper"), resultSet.getString("pump"), resultSet.getString("fuelType"), resultSet.getDouble("StartMeter"), resultSet.getString("TankID"), resultSet.getString("Date"), resultSet.getString("Time"), resultSet.getString("Status"), resultSet.getDouble("EndMeter"));
                shedule.setScheduleID(resultSet.getInt("scheduleID"));
                schedule.add(shedule);

            }

        }
        return schedule;
    }
}
