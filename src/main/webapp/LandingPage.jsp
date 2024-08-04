<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grocery Application - Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eef2f3;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            text-align: center;
            padding: 50px 20px;
            max-width: 800px;
            margin: 0 auto;
            background: white;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            font-size: 2.5em;
            color: #4CAF50;
            margin-bottom: 20px;
        }
        .link {
            display: block;
            margin: 10px 0;
            font-size: 1.5em;
            color: #007BFF;
            text-decoration: none;
            padding: 10px 0;
            border-radius: 5px;
            transition: background-color 0.3s, color 0.3s;
        }
        .link:hover {
            background-color: #007BFF;
            color: white;
        }
        .link-icon {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Grocery Application</h1>
        <c:if test="${not empty username}">
            <p>Hello, ${username}</p>
            <a class="link" href="AddItem.jsp">
                <i class="fas fa-plus link-icon"></i>Add New Grocery Item
            </a>
            <a class="link" href="SearchItem.jsp">
                <i class="fas fa-search link-icon"></i>Search for Grocery Item
            </a>
            <a class="link" href="GetAll.jsp">
                <i class="fas fa-list link-icon"></i>View All Grocery Items
            </a>
            <a class="link" href="Delete.jsp">
                <i class="fas fa-trash link-icon"></i>Delete Grocery Item by Name
            </a>
            <a class="link" href="UpdateItem.jsp">
                <i class="fas fa-edit link-icon"></i>Update Existing Grocery Item
            </a>
        </c:if>
        <c:if test="${empty username}">
            <script type="text/javascript">
                window.location.href = "Login.jsp";
            </script>
        </c:if>
    </div>
</body>
</html>
