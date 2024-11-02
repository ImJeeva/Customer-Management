<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.spring.entity.Customer, com.spring.entity.User" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
    <link rel="stylesheet" type="text/css" href="CSS/getCustomer.css">
</head>
<body>

<!-- Navigation Bar -->

        <% 
        User user = (User) session.getAttribute("user");

        %>
<nav>
    <div class="nav-title">Customer Management</div>
    <div class="nav-links">
        <a class = "nav-name">Welcome! <%= user.getUserName() %></a>
        <a href="logout">Logout</a>
    </div>
</nav>

<div class="header">
    <h2>Customer Details:</h2>
    <form action="addcustomer" method="post">
        <button class="btn-add" type="submit">Add Customer</button>
    </form>
</div>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <% 
            List<Customer> customers = (List<Customer>) request.getAttribute("list");
            if (customers != null && !customers.isEmpty()) {
                for(Customer cust : customers) { 
        %>
        <tr>
            <td><%= cust.getId() %></td>
            <td><%= cust.getName() %></td>
            <td><%= cust.getEmail() %></td>
            <td><%= cust.getDepartment() %></td>
            <td><%= cust.getSalary() %></td>
            <td>
                <form action="updateCustomer" method="get" style="display:inline;">
                    <input type="hidden" name="id" value="<%= cust.getId() %>">
                    <button class="btn-update" type="submit">Update</button>
                </form>

                <form action="deleteCustomer" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= cust.getId() %>">
                    <button class="btn-delete" type="submit" onclick="return confirm('Are you sure you want to delete this customer?')">Delete</button>
                </form>
            </td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr>
            <td colspan="6">No customers found</td>
        </tr>
        <% } %>
    </tbody>
</table>

</body>
</html>
