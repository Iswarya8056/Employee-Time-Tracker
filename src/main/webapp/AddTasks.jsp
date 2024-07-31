<!DOCTYPE html>
<html>
<head>
    <title>Add Task</title>
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
            max-width: 800px;
            width: 100%;
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
            font-size: 24px;
        }
        form {
            display: flex;
            flex-wrap: wrap;
            gap: 15px;
            max-width: 100%;
            width: 100%;
        }
        .form-group {
            display: flex;
            flex-direction: column;
            width: calc(50% - 15px); /* Two items per row with gap adjustment */
            box-sizing: border-box;
        }
        .form-group label {
            color: #555;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input, .form-group select, .form-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }
        textarea {
            height: 80px;
            resize: vertical;
        }
        input[type="submit"] {
            background-color: #28a745; /* Green color */
            color: #ffffff;
            border: none;
            cursor: pointer;
            font-size: 16px;
            padding: 12px;
            border-radius: 4px;
            width: 100%;
            margin-top: 20px;
        }
        input[type="submit"]:hover {
            background-color: #218838; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Task</h1>
        <form action="AddTaskServlet" method="post">
            <div class="form-group">
                <label for="project_name">Project Name:</label>
                <input type="text" id="project_name" name="project_name" required>
            </div>

            <div class="form-group">
                <label for="project_id">Project ID:</label>
                <input type="number" id="project_id" name="project_id" required>
            </div>

            <div class="form-group">
                <label for="employee_name">Employee Name:</label>
                <input type="text" id="employee_name" name="employee_name" required>
            </div>

            <div class="form-group">
                <label for="task_category">Task Category:</label>
                <input type="text" id="task_category" name="task_category" required>
            </div>

            <div class="form-group">
                <label for="task_date">Task Date:</label>
                <input type="date" id="task_date" name="task_date" required>
            </div>

            <div class="form-group">
                <label for="start_time">Start Time:</label>
                <input type="time" id="start_time" name="start_time" required>
            </div>

            <div class="form-group">
                <label for="end_time">End Time:</label>
                <input type="time" id="end_time" name="end_time" required>
            </div>

            <div class="form-group">
                <label for="duration">Duration (hours):</label>
                <input type="number" step="0.01" id="duration" name="duration" required>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description"></textarea>
            </div>

            <input type="submit" value="Add Task">
        </form>
    </div>
</body>
</html>
