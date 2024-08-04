<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Grocery - Grocery Application</title>
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
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-weight: bold;
        }
        select, input[type="submit"] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            text-decoration: none;
            color: #007BFF;
            font-size: 16px;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
        .message {
            color: red;
            font-size: 18px;
            margin-top: 20px;
        }
        .grocery-details {
            margin-top: 20px;
            font-size: 16px;
        }
        .grocery-details label {
            font-weight: bold;
            color: #4CAF50;
        }
        .grocery-details span {
            color: #333;
        }
        .total-price {
            color: blue;
            font-size: 18px;
        }
        .action-link {
            text-align: center;
            margin-top: 20px;
        }
        .action-link a {
            font-size: 1.5em;
            color: navy;
            text-decoration: none;
        }
        .action-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Search Grocery</h1>
        <form action="search.do" method="post">
            <div>
                <label for="name">Select Item</label>
                <select name="name" id="name">
                    <option>Long Grain Basmati Rice</option>
                    <option>Wheat Flour</option>
                    <option>Maida</option>
                    <option>Green Gram Dal</option>
                    <option>Coffee</option>
                    <option>Coriander Seeds</option>
                    <option>Red Chillies Powder</option>
                    <option>Tamarind</option>
                    <option>Cooking Oil</option>
                </select>
            </div>
            <input type="submit" value="Search">
        </form>
        <div class="back-link">
            <a href="LandingPage.jsp">Back to Home</a>
        </div>

        <h2 class="message">${message}</h2>

        <div class="grocery-details">
            <p><label>Grocery Name:</label> <span>${grocery.name}</span></p>
            <p><label>Quantity:</label> <span>${grocery.quantity}</span></p>
            <p><label>Price:</label> <span>${grocery.price}</span></p>
            <p><label>Type:</label> <span>${grocery.type}</span></p>
            <p><label>Brand:</label> <span>${grocery.brand}</span></p>
        </div>

        <div class="total-price">${totalprice}</div>

        <div class="action-link">
            <a href="UpdateItem.jsp">Update Item</a>
        </div>
    </div>
</body>
</html>
