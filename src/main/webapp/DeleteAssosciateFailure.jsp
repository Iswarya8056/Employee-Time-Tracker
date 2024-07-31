<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Associate Failure</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        .message-container {
            border: 2px solid #f44336;
            border-radius: 5px;
            display: inline-block;
            padding: 20px;
            background-color: #ffdddd;
        }
        .message-container h1 {
            color: #f44336;
        }
        .message-container p {
            color: #555;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
        }
        .back-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <h1>Delete Associate Failed</h1>
        <p>Sorry, we couldn't delete the associate. Please try again.</p>
        <a href="ViewAssosciate.jsp" class="back-link">Back to View Associates</a>
    </div>
</body>
</html>
