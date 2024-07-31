<%@ page import="java.util.*, java.sql.*, EMPmodel.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Associates</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .edit, .delete {
            padding: 5px 10px;
            text-decoration: none;
        }
        .edit {
            background-color: #4CAF50;
            color: white;
        }
        .delete {
            background-color: #f44336;
            color: white;
        }
        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .back-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Associate Details</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Username</th>
            <th>Role</th>
            <th>Email</th>
            <th>Mobile No</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <%
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db6", "root", "Iswarya@1910");
                String sql = "SELECT id, user_name, username, role, email, mobile_no, date_of_birth, address FROM users";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                while (rs.next()) {
                    User user = new User(
                        rs.getInt("id"),
                        rs.getString("user_name"),
                        rs.getString("username"),
                        null, // Not fetching the password for security reasons
                        rs.getString("role"),
                        rs.getString("email"),
                        rs.getString("mobile_no"),
                        rs.getString("date_of_birth"),
                        rs.getString("address")
                    );
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getUserName() %></td>
            <td><%= user.getUsername() %></td>
            <td><%= user.getRole() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getMobileNo() %></td>
            <td><%= user.getDateOfBirth() %></td>
            <td><%= user.getAddress() %></td>
            <td>
                <a class="edit" href="EditAssosciateServlet?id=<%= user.getId() %>">Edit</a>
                <a class="delete" href="DeleteAssosciateServlet?id=<%= user.getId() %>" onclick="return confirm('Are you sure you want to delete this associate?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
                if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
                if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
            }
        %>
    </table>
    <a href="adminDashboard.jsp" class="back-button">Back to Admin Dashboard</a>
</body>
</html>
