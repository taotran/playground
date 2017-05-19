<%--
  Created by IntelliJ IDEA.
  User: tvtran
  Date: 5/11/2017
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login failed</title>
</head>
<body>

    This is user list page
    <c:forEach items="${users}" var="user">
        ${user.username} <br />
    </c:forEach>
    <c:forEach var="i" begin="1" end="${noOfPages + 1}">
        <a href="<c:out value="/user/list?page=${i}"/>" >${i}</a>  |
    </c:forEach>
    <c:out value="Total number of Pages: ${noOfPages}" />
</body>
</html>
