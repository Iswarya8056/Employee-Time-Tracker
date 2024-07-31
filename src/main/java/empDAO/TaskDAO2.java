package empDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import EMPmodel.Task1;

public class TaskDAO2 {
    private static final String URL = "jdbc:mysql://localhost:3306/db6";
    private static final String USER = "root";
    private static final String PASSWORD = "Iswarya@1910";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Task1> getAllTasks(String employeeName) {
        List<Task1> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE employee_name = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, employeeName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Task1 task = new Task1(
                        rs.getInt("id"),
                        rs.getString("project_name"),
                        rs.getString("task_category"),
                        rs.getString("task_date"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getDouble("duration"),
                        rs.getString("description"),
                        rs.getString("employee_name")
                    );
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Task1 getTaskById(int id) {
        Task1 task = null;
        String sql = "SELECT * FROM tasks WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    task = new Task1(
                        rs.getInt("id"),
                        rs.getString("project_name"),
                        rs.getString("task_category"),
                        rs.getString("task_date"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getDouble("duration"),
                        rs.getString("description"),
                        rs.getString("employee_name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    public void updateTask(Task1 task) {
        String sql = "UPDATE tasks SET project_name = ?, task_category = ?, task_date = ?, start_time = ?, end_time = ?, duration = ?, description = ?, employee_name = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, task.getProjectName());
            ps.setString(2, task.getTaskCategory());
            ps.setString(3, task.getTaskDate());
            ps.setString(4, task.getStartTime());
            ps.setString(5, task.getEndTime());
            ps.setDouble(6, task.getDuration());
            ps.setString(7, task.getDescription());
            ps.setString(8, task.getEmployeeName());
            ps.setInt(9, task.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(int id, String employeeName) {
        String sql = "DELETE FROM tasks WHERE id = ? AND employee_name = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, employeeName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
