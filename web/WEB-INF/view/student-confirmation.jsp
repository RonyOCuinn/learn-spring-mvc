<jsp:useBean id="student" scope="request" type="com.ronyo.springdemo.mvc.Student"/>
<%--
  Created by IntelliJ IDEA.
  User: ronyo
  Date: 11/09/2018
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>

The student is confirm: ${student.firstName} ${student.lastName}
<br>
The country is ${student.country}
<br>
Favourite Language: ${student.favouriteLanguage}
<br><br>
Operation System:
<ul>
    <C:forEach var="temp" items="${student.favouriteOs}">
        <li>${temp}</li>
    </C:forEach>
</ul>

</body>
</html>
