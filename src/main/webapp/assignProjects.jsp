<%@ page import="java.util.List" %>
<%@ page import="empDAO.EmployeeDAO" %>
<%@ page import="EMPmodel.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>Assign Project</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            width: 100%;
            text-align: center;
        }
        h2 {
            color: #007bff;
            margin-bottom: 20px;
            font-size: 24px;
        }
        label {
            display: block;
            margin-top: 10px;
            color: #333;
            text-align: left;
            font-weight: bold;
        }
        select, input[type="text"], input[type="date"], textarea {
            width: calc(100% - 20px);
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            height: 100px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px;
            margin-top: 20px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .back-button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
            width: fit-content;
        }
        .back-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Assign Project to Associate</h2>
        
        <form action="AssignProjectServlet" method="post">
            <label for="employee_name">Associate:</label>
            <select id="employee_name" name="employee_name">
                <% 
                    EmployeeDAO empDAO = new EmployeeDAO();
                    List<Employee> associates = empDAO.getAllAssociates();
                    for (Employee emp : associates) {
                %>
                    <option value="<%= emp.getUserName() %>"><%= emp.getUserName() %></option>
                <% 
                    }
                %>
            </select><br><br>
            
            <label for="project_name">Project Name:</label>
            <input type="text" id="project_name" name="project_name" required><br><br>
            
            <label for="deadline">Deadline:</label>
            <input type="date" id="deadline" name="deadline" required><br><br>
            
            <label for="description">Description:</label>
            <textarea id="description" name="description"></textarea><br><br>
            
            <input type="submit" value="Assign Project">
        </form>
        
        <a href="adminDashboard.jsp" class="back-button">Back to Admin Dashboard</a>
    </div>
</body>
</html>
