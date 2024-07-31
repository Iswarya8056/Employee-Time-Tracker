package empDAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAssosciateDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db6";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Iswarya@1910";

    public boolean createAssociate(String userName, String username, String password, String role, String email, String mobile, String dob, String address) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        boolean isSuccess = false;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // SQL insert statement
            String sql = "INSERT INTO users (user_name, username, password, role, email, mobile_no, date_of_birth, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, role);
            pstmt.setString(5, email);
            pstmt.setString(6, mobile);
            pstmt.setString(7, dob);
            pstmt.setString(8, address);

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = (rowsAffected > 0);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isSuccess;
    }
}

