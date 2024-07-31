
package empDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EMPmodel.Employee;

public class EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/db6";
    private static final String USER = "root";
    private static final String PASSWORD = "Iswarya@1910";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Employee> getAllAssociates() throws SQLException {
        List<Employee> associates = new ArrayList<>();
        String sql = "SELECT id, user_name FROM users WHERE role = 'Associate'";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setUserName(rs.getString("user_name"));
                associates.add(emp);
            }
        }
        return associates;
    }
}

