<%--
  Created by IntelliJ IDEA.
  User: tvtran
  Date: 5/16/2017
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Login Form</title>
</head>
<body>

<form name="f" id="loginForm" action="/login" method="POST">
    <div id="login-container">
        <div>
            <span>Username</span>
            <div><input type="text" name="username" placeholder="Username" /></div>
        </div>

        <div>
            <span>Password</span>
            <div><input type="password" name="password" /></div>
        </div>

        <div>
            <input type="submit" name="submit" value="Login" />
        </div>
        <%--<input type="hidden"--%>
               <%--name="${_csrf.parameterName}"--%>
               <%--value="${_csrf.token}"/>--%>
    </div>

</form>

</body>
</html>
