package empDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import EMPmodel.Project;


public class ProjectDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/db6";
    private static final String USER = "root";
    private static final String PASSWORD = "Iswarya@1910";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void assignProject(Project project) throws SQLException {
        String sql = "INSERT INTO projects (project_name, employee_name, deadline, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, project.getProjectName());
            stmt.setString(2, project.getEmployeeName());  // Use employee name from project
            stmt.setString(3, project.getDeadline());
            stmt.setString(4, project.getDescription());
            stmt.executeUpdate();
        }
    }
}
