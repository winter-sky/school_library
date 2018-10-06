<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02.10.2018
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Show pupils books
</h1>
<h3>Books List</h3>
<c:if test="${!empty showPupilBooks}">
    <table class="tg">
        <tr>
            <th width="80">Book ID</th>
            <th width="120">Book Name</th>
            <th width="120">Book Author</th>
            <th width="120">Book Genre</th>
            <th width="120">Book Country</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${showPupilBooks}" var="books">
            <tr>
                <td>${books.bookId}</td>
                <td>${books.name}</td>
                <td>${books.author}</td>
                <td>${books.genre}</td>
                <td>${books.country}</td>
                <td><a href="<c:url value='/removebook/${books.bookId}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
