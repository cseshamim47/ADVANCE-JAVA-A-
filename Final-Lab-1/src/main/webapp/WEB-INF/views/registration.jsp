<%@ page contentType="text/html" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head></head>
<body>
    <h3>Registration Page</h3>

    <form:form method="post" action="store" modelAttribute="student">

        <label>Id</label>
        <form:input path="id" id="id" type="number"/>
        <form:errors path="id"/>

        <br><br>


        <label>Full Name</label>
        <form:input path="name" id="name"/>
        <form:errors path="name"/>

        <br><br>

        <label>Date Of Birth</label>
        <form:input type="date" path="dateOfBirth" id="dateOfBirth"/>
        <form:errors path="dateOfBirth"/>

        <br><br>

        <label>Email</label>
        <form:input path="email" id="email"/>
        <form:errors path="email"/>

        <br><br>

        <label>Gender</label>
        <form:radiobutton path="gender" value="MALE" label="Male"/>
        <form:radiobutton path="gender" value="FEMALE" label="Female"/>
        <form:errors path="gender"/>

        <br><br>

       <label>Quota</label>
       <form:checkbox path="quota" id="quota" value="1"/>
       <form:errors path="quota"/>

        <br><br>

        <label>Country</label>
        <form:select path="country" id="country">
            <form:option value="Bangladesh" label="Bangladesh"/>
            <form:option value="India" label="India"/>
            <form:option value="Nepal" label="Nepal"/>
        </form:select>
        <form:errors path="country"/>

        <br><br>

        <input type="submit" value="Register" />

    </form:form>

    <a href="/">Home</a>

</body>
</html>
