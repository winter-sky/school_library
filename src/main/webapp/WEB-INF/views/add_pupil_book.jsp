<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 05.10.2018
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Pupils List</h3>
<c:if test="${!empty showPupil}">
    <table class="tg">
        <tr>
            <th width="80">Pupil ID</th>
            <th width="120">Pupil Name</th>
            <th width="120">Pupil Grade</th>
        </tr>

            <tr>
                <td>${showPupil.pupilId}</td>
                <td>${showPupil.name}</td>
                <td>${showPupil.grade}</td>
            </tr>
    </table>
</c:if>
<h3>Books List</h3>
<c:if test="${!empty listBooks}">
    <table class="tg">
        <tr>
            <th width="80">Book ID</th>
            <th width="120">Book Name</th>
            <th width="120">Book Author</th>
            <th width="120">Book Genre</th>
            <th width="120">Book Country</th>
        </tr>
        <c:forEach items="${listBooks}" var="books">
            <tr>
                <td>${books.bookId}</td>
                <td>${books.name}</td>
                <td>${books.author}</td>
                <td>${books.genre}</td>
                <td>${books.country}</td>
                <td> <a href="<c:url value='/addBookToPupil/${showPupil.pupilId}/${books.bookId}' />" >Add this book</a></td>
            </tr>

        </c:forEach>
    </table>
</c:if>

</body>
</html>
