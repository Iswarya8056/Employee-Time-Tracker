package empDAO;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TaskDAO1 {

    private static final String URL = "jdbc:mysql://localhost:3306/db6";
    private static final String USER = "root";
    private static final String PASSWORD = "Iswarya@1910";

    // Method to establish and return a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public Map<String, Double> getDailyData() {
        Map<String, Double> data = new HashMap<>();
        String sql = "SELECT employee_name, SUM(duration) as total_duration FROM tasks WHERE task_date = CURDATE() GROUP BY employee_name";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                data.put(rs.getString("employee_name"), rs.getDouble("total_duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, Double> getWeeklyData() {
        Map<String, Double> data = new HashMap<>();
        String sql = "SELECT employee_name, WEEK(task_date) as week_number, SUM(duration) as total_duration " +
                     "FROM tasks WHERE MONTH(task_date) = MONTH(CURDATE()) GROUP BY employee_name, week_number";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String key = rs.getString("employee_name") + " - Week " + rs.getInt("week_number");
                data.put(key, rs.getDouble("total_duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String, Double> getMonthlyData() {
        Map<String, Double> data = new HashMap<>();
        String sql = "SELECT employee_name, MONTH(task_date) as month_number, SUM(duration) as total_duration " +
                     "FROM tasks GROUP BY employee_name, month_number";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String key = rs.getString("employee_name") + " - Month " + rs.getInt("month_number");
                data.put(key, rs.getDouble("total_duration"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
