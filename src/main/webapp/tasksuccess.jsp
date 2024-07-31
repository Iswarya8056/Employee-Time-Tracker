<!DOCTYPE html>
<html>
<head>
    <title>Task Added Successfully</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e0f7fa;
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
            text-align: center;
        }
        h1 {
            color: #00796b;
            margin-bottom: 20px;
        }
        a {
            text-decoration: none;
            color: #00796b;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container a {
            text-decoration: none;
            color: #ffffff;
            background-color: #00796b; /* Green color */
            padding: 10px 20px;
            border-radius: 5px;
            font-weight: bold;
            font-size: 16px;
            display: inline-block;
        }
        .button-container a:hover {
            background-color: #004d40; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Task Added Successfully!</h1>
        <div class="button-container">
            <a href="AddTasks.jsp">Add Another Task</a>
            <a href="associateDashboard.jsp">Back to Associate Dashboard</a>
        </div>
    </div>
</body>
</html>
