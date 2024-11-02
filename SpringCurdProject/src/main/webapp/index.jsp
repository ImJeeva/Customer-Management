<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Login</title>
    <!-- Link to the external CSS file -->
    <link rel="stylesheet" type="text/css" href="CSS/login.css">
</head>
<body>

    <!-- Navigation Bar -->
    <nav>
        <div class="nav-title">Customer Management</div>
        <div class="nav-links">
            <a href="signUp.jsp">Sign Up</a>
        </div>
    </nav>

    <div class="login-container">
        <h2>Login</h2>
        <form action="loginServletr" method="post">
            <input type="email" name="email" placeholder="Enter Email" required><br>
            <input type="password" name="password" placeholder="Enter Password" required><br>
            <button type="submit" class="login-button">Login</button>
        </form>
        <p>Don't have an account? <a href="signUp.jsp">Sign Up</a></p>
    </div>

</body>
</html>
