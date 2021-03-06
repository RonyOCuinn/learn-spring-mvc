<%--
  Created by IntelliJ IDEA.
  User: ronyo
  Date: 12/09/2018
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>
    <style>
        .error {color:red}
    </style>
</head>
<body>
<%--@elvariable id="customer" type="com.ronyo.springdemo.mvc.Customer"--%>
    <form:form action="processForm" modelAttribute="customer">
        First name: <form:input path="firstName" />
        Last name: <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error" />
        <br><br>
        Free Passes: <form:input path="freePasses" />
        <form:errors path="freePasses" cssClass="error" />
        <br><br>
        Postal Code: <form:input path="postCode" />
        <form:errors path="postCode" cssClass="error"/>
        <br><br>
        Course Code: <form:input path="courseCode" />
        <form:errors path="courseCode" cssClass="error"/>
        <br><br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>
