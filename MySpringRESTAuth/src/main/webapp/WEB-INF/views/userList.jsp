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
//                location.hash = "#page=5";
                $('#nextPage').attr('href', '#page=5');
                $('#userContainer').empty();
                $('#ajaxLoading').css("display", "inline");
                $.ajax({
                    url: '/user/getUsers?page=2',
                    dataType: 'application/json',
                    type: 'GET',
                    complete: function (data) {
                        console.log('test testtttt');
                        var userList = JSON.parse(data.responseText);
                        $.each(userList, function (i, item) {
                            console.log(item);

                            $('#userContainer').append(item.username);
                            $('#userContainer').append('<br />');
                            $('#ajaxLoading').css("display", "none");

                        })
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
<img id="ajaxLoading" src="/images/hourglass.gif" style="display: none;"> <br />

<a id="nextPage" href="#">Next</a>
<br/>
<c:out value="Total number of Pages: ${noOfPages}"/>
</body>
</html>
