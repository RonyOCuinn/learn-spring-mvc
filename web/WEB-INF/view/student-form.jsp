<%--
  Created by IntelliJ IDEA.
  User: ronyo
  Date: 11/09/2018
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

    <%--@elvariable id="student" type="com.rony.springdemo.mvc.Student"--%>
    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path="firstName" />
        Last Name: <form:input path="lastName" />
        Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}" />
        </form:select>
        <br>
        Java <form:radiobutton path="favouriteLanguage" value="Java" />
        Python <form:radiobutton path="favouriteLanguage" value="Python" />
        <br>
        Windows <form:checkbox path="favouriteOs" value="Windows"/>
        Linux <form:checkbox path="favouriteOs" value="Linux"/>
        <input type="submit" value="Submit" />
    </form:form>

</body>
</html>
