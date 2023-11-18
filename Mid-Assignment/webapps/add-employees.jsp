<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*, java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
           <h1>Add Employee</h1>
           <form method="post" action="add-employee">
               <label for="employee_id">Employee ID:</label>
               <input type="text" name="id" required><br>

               <label for="name">Name:</label>
               <input type="text" name="name" required><br>

               <label for="date_of_birth">Date of Birth:</label>
               <input type="text" name="dob" placeholder="DD/MM/YYYY" required><br>

               <label for="email">Email:</label>
               <input type="email" name="email" required><br>

               <label for="joining_date">Joining Date:</label>
               <input type="date" name="joindate" id="joining_date" required><br>

               <label for="employee_type">Employee Type:</label>
               <select name="empType" id="employee_type" required>
                   <option value="Officer">Officer</option>
                   <option value="Staff">Staff</option>
               </select><br>

               <input type="submit" value="Add Employee">
           </form>

</body>
</html>