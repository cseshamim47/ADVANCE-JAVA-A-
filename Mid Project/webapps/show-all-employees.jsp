<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
</head>
<body>

<h1>Employee List</h1>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Join Date</th>
            <th>User Type</th>
            <th>Vacation Leave</th>
            <th>Sick Leave</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="employeeAtt" items="${employeeList}">
            <tr>
                <td>${employeeAtt.id}</td>
                <td>${employeeAtt.name}</td>
                <td>${employeeAtt.dob}</td>
                <td>${employeeAtt.email}</td>
                <td>${employeeAtt.joindate}</td>
                <td>${employeeAtt.userType}</td>
                <td>${employeeAtt.vacationLeave}</td>
                <td>${employeeAtt.sickLeave}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
