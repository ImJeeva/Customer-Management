<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Sign Up</title>
    <!-- Link to the external CSS file -->
    <link rel="stylesheet" type="text/css" href="CSS/siggn.css">
</head>
<body>

    <!-- Navigation Bar -->
    <nav>
        <div class="nav-title">Customer Management</div>
        <div class="nav-links">
            <a href="index.jsp">Login</a>
        </div>
    </nav>

    <div class="signup-container">
        <h2>Sign Up</h2>
        <form action="signupServlet" method="post">
            <input type="text" name="name" placeholder="Enter Name" required><br>
            <input type="email" name="email" placeholder="Enter Email" required><br>
            <input type="password" name="password" placeholder="Enter Password" required><br>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required><br>
            <button type="submit" class="signup-button">Sign Up</button>
        </form>
                <p>Have an account? <a href="index.jsp">Login</a></p>
        
    </div>

</body>
</html>
