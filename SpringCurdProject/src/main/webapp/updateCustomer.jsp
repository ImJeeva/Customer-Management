<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.spring.entity.Customer, com.spring.entity.User" %>    

<!DOCTYPE html>
<html>
<head>
    <title>Update Customer</title>
    <!-- Link to the external CSS file -->
    <link rel="stylesheet" type="text/css" href="CSS/updateCustomer.css">
</head>
<body>
        <% 
        User user = (User) session.getAttribute("user");

        %>

<!-- Navigation Bar -->
<nav>
    <div class="nav-title">Customer Management</div>
    <div class="nav-links">
        <a>Welcome !<%= user.getUserName() %></a>
        <a href="customerdata">Customer Data</a>
        
    </div>
</nav>

<h2>Update Customer Details</h2>

<form action="saveUpdatedCustomer" method="post">
    <!-- Hidden field to store customer ID -->
    <input type="hidden" name="id" value="${customer.id}" />
    
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${customer.name}" required />

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${customer.email}" required />

    <label for="department">Department:</label>
    <input type="text" id="department" name="department" value="${customer.department}" required />

    <label for="salary">Salary:</label>
    <input type="number" id="salary" name="salary" value="${customer.salary}" required />

    <button type="submit">Update Customer</button>
</form>

</body>
</html>
