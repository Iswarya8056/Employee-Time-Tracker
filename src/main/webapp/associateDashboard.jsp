<!DOCTYPE html>
<html>
<head>
    <title>Associate Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333333;
            text-align: center;
            margin-bottom: 20px;
        }
        nav {
            margin-bottom: 20px;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
            text-align: center;
        }
        nav ul li {
            display: inline;
            margin: 0 10px;
        }
        nav ul li a {
            text-decoration: none;
            color: #28a745; /* Green color */
            font-weight: bold;
        }
        nav ul li a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, Associate</h1>
        <nav>
            <ul>
                <li><a href="AssociateDashboardServlet?action=addtasks">Add Tasks</a></li>
               
                <li><a href="AssociateDashboardServlet?action=logout">Logout</a></li>
            </ul>
        </nav>
    </div>
</body>
</html>
