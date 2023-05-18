<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Access Denied</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h1 {
            color: #333;
            font-size: 36px;
            margin-bottom: 20px;
        }

        p {
            color: #666;
            font-size: 18px;
            margin-bottom: 20px;
        }

        button {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }

        button:hover {
            background-color: #3e8e41;
        }
    </style>
    <script>
        setTimeout(function() {
            window.location.href = "Home";
        }, 5000);
    </script>
</head>
<body>
    <div class="container">
        <h1>Access Denied</h1>
        <p>You don't have sufficient privileges to access this page.</p>
        <button onclick="window.location.href='Home'">Go to Home Page</button>
    </div>
</body>
</html>
