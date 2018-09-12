<%--@elvariable id="customer" type="com.rony.springdemo.mvc.Customer"--%>
<%--
  Created by IntelliJ IDEA.
  User: ronyo
  Date: 12/09/2018
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
    Customer confirmed: ${customer.firstName} ${customer.lastName}
</body>
</html>
