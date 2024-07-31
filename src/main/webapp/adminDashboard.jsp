<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
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
        h1 {
            color: #333333;
        }
        nav {
            margin-top: 20px;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin: 10px 0;
        }
        a {
            text-decoration: none;
            color: #ffffff;
            background-color: #007bff;
            padding: 15px 20px; /* Increased padding for better size */
            border-radius: 4px;
            display: block;
            width: 100%; /* Ensure full width of the container */
            max-width: 300px; /* Fixed maximum width for consistency */
            margin: 0 auto; /* Center align the links */
        }
        a:hover {
            background-color: #0056b3
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, Admin</h1>
        <nav>
            <ul>
                <li><a href="CreateAssosciate.jsp">Create Associate</a></li>
               
                
                
                <li><a href="ViewAssosciate.jsp">View Associate</a></li>
                <li><a href="assignProjects.jsp">Project Assignment</a></li>
                <li><a href="ViewAssosciateCharts.jsp">View Charts </a></li>
                
                <li><a href="Logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </div>
</body>
</html>
