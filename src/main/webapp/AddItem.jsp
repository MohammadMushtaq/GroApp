<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.do");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Grocery Item - Grocery Application</title>
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
        select, input[type="number"], input[type="submit"] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .back-link {
            display: block;
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Add New Grocery Item</h1>
        <form action="add.do" method="post">
            <div>
                <label for="name">Item Name</label>
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

            <div>
                <label for="quantity">Quantity</label>
                <select name="quantity" id="quantity">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                </select>
            </div>

            <div>
                <label for="price">Price</label>
                <input type="number" name="price" id="price" min="0" step="0.01" required>
            </div>

            <div>
                <label for="type">Unit</label>
                <select name="type" id="type">
                    <option>kg</option>
                    <option>gms</option>
                    <option>ltr</option>
                    <option>piece</option>
                    <option>dozen</option>
                    <option>quant</option>
                </select>
            </div>

            <div>
                <label for="brand">Brand</label>
                <select name="brand" id="brand">
                    <option>Sunflower</option>
                    <option>Aashirvaad</option>
                    <option>Mount Everest</option>
                    <option>Bru</option>
                    <option>Reliance</option>
                    <option>Tata</option>
                    <option>Haldiram</option>
                </select>
            </div>

            <div>
                <input type="submit" value="Add Item">
            </div>
        </form>
        <div class="back-link">
            <a href="LandingPage.jsp">Back to Home</a>
        </div>
    </div>
</body>
</html>
