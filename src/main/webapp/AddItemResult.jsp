<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Grocery Item Details - Grocery Application</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #eef2f3;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #4CAF50;
            margin-bottom: 20px;
        }
        .message {
            color: red;
            font-size: 18px;
            margin-bottom: 10px;
        }
        .details {
            font-size: 16px;
        }
        .details label {
            font-weight: bold;
            color: #4CAF50;
        }
        .details span {
            color: #333;
        }
        .action-links {
            text-align: center;
            margin-top: 20px;
        }
        .action-links a {
            text-decoration: none;
            color: #007BFF;
            font-size: 16px;
            display: block;
            margin: 10px 0;
        }
        .action-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Grocery Item Details</h1>
        <div class="message">${message}</div>
        <div class="details">
            <p><label>Name:</label> <span>${grocery.name}</span></p>
            <p><label>Quantity:</label> <span>${grocery.quantity}</span></p>
            <p><label>Price:</label> <span>${grocery.price}</span></p>
            <p><label>Unit:</label> <span>${grocery.type}</span></p>
            <p><label>Brand:</label> <span>${grocery.brand}</span></p>
            <p><label>Total Price:</label> <span>${totalprice}</span></p>
        </div>
        <div class="action-links">
            <a href="AddItem.jsp">Add Another Item</a>
            <a href="LandingPage.jsp">Go to Home Page</a>
        </div>
    </div>
</body>
</html>
