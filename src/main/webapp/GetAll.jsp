<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Get All Grocery</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
        }
        form {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            color: red;
            font-size: 18px;
        }
        .grocery-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .grocery-item label {
            font-weight: bold;
        }
        .home-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
        .home-link a {
            text-decoration: none;
            color: #4CAF50;
            font-size: 18px;
        }
        .home-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Get All Grocery</h1>
        <form action="getAllGrocery.do">
            <input type="submit" value="Click To Get All" />
        </form>

        <div class="message">
            <h2>${message}</h2>
        </div>

        <div>
            <c:forEach items="${groceryList}" var="grocery">
                <div class="grocery-item">
                    <label>Grocery Name:</label> ${grocery.name}<br>
                    <label>Quantity:</label> ${grocery.quantity}<br>
                    <label>Price:</label> ${grocery.price}<br>
                    <label>Type:</label> ${grocery.type}<br>
                    <label>Brand:</label> ${grocery.brand}<br>
                </div>
            </c:forEach>
        </div>

        <div class="home-link">
            <a href="LandingPage.jsp">Home Page</a>
        </div>
    </div>
</body>
</html>
