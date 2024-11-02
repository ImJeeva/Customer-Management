<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.spring.entity.Customer, com.spring.entity.User" %>    

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Customer</title>
    <link rel="stylesheet" type="text/css" href="CSS/addCustomer.css"> <!-- Link to external CSS -->
</head>
<body>
       <% 
       User user = (User) session.getAttribute("user");
       System.out.println(user.getUserName());
        %>

<nav>
    <div class="nav-title">Customer Management</div>
    <div class="nav-links">
        <a> Welcome!  <%= user.getUserName()%></a> 
        <a href="customerdata">Customer Data</a>
        
    </div>
</nav>

<form action="addcustomerdata" method="post">
    <h2>Add Customer</h2>

    <label for="name">Name</label>
    <input type="text" name="name" id="name" required>

    <label for="email">Email</label>
    <input type="email" name="email" id="email" required>

    <label for="department">Department</label>
    <input type="text" name="department" id="department" required>

    <label for="salary">Salary</label>
    <input type="number" name="salary" id="salary" required>

    <button type="submit">Submit</button>
</form>

</body>
</html>
