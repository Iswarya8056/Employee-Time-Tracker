package empDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/db6";
    private static final String USER = "root";
    private static final String PASSWORD = "Iswarya@1910";

    // Method to establish and return a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to add a new task to the database
    public boolean addTask(String projectName, String employeeName, int projectId, String taskCategory, String taskDate,
                           String startTime, String endTime, double duration, String description) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean isAdded = false;

        try {
            // Establish connection
            conn = getConnection();
            // SQL query to insert a new task
            String sql = "INSERT INTO tasks (project_name, employee_name, project_id, task_category, task_date, " +
                         "start_time, end_time, duration, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            // Set parameters
            ps.setString(1, projectName);
            ps.setString(2, employeeName);
            ps.setInt(3, projectId);
            ps.setString(4, taskCategory);
            ps.setString(5, taskDate);
            ps.setString(6, startTime);
            ps.setString(7, endTime);
            ps.setDouble(8, duration);
            ps.setString(9, description);
            
            // Execute update and check if successful
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return isAdded;
    }
}
