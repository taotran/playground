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
    <title>List of Users</title>
    <script src="/js/jquery-1.11.1.js"></script>

    <script language="javascript">
        $(document).ready(function () {
//            alert('text test');
            $('#nextPage').click(function () {
                $.ajax({
                    url: '/user/getUsers',
                    contentType: "application/json; charset=utf-8",
                    data: ({page: 5}),
                    dataType: 'json',
                    success: function (response) {
                        console.log('TESTTTTTTTTTTTTTTTTT');
                        var list = JSON.parse(response);
                        console.log(list);
                    }
                })
            })
        });
    </script>
</head>

<body>

This is user list page <br/>
<div id="userContainer" style="width: 100%; height: 400px; overflow-y: scroll;">
    <c:forEach items="${users}" var="user">
        ${user.username} <br/>
    </c:forEach>
</div>
<a id="prevPage" href="#">Prev</a>

<c:forEach var="i" begin="1" end="${noOfPages + 1}">
    <a id="nextPageRef" href="<c:out value="/user/list?page=${i}"/>">${i}</a> |
    <%--<a id="nextPageRef" href="#">${i}</a> |--%>
</c:forEach>

<a id="nextPage" href="#">Next</a>
<br/>
<c:out value="Total number of Pages: ${noOfPages}"/>
</body>
</html>
