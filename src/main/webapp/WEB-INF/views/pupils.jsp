<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.10.2018
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Add a Pupil
</h1>

<c:url var="addAction" value="/pupils/add" ></c:url>

<form:form action="${addAction}" commandName="pupils">
    <table>
        <c:if test="${!empty pupils.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="pupilId" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="pupilId" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="grade">
                    <spring:message text="Grade"/>
                </form:label>
            </td>
            <td>
                <form:input path="grade" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty pupils.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Pupil"/>" />
                </c:if>
                <c:if test="${empty pupils.name}">
                    <input type="submit"
                           value="<spring:message text="Add Pupil"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Pupils List</h3>
<c:if test="${!empty listPupils}">
    <table class="tg">
        <tr>
            <th width="80">Pupil ID</th>
            <th width="120">Pupil Name</th>
            <th width="120">Pupil Grade</th>
            <th width="60">Show</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPupils}" var="pupils">
            <tr>
                <td>${pupils.pupilId}</td>
                <td>${pupils.name}</td>
                <td>${pupils.grade}</td>
                <td><a href="<c:url value='/pupils_books/${pupils.pupilId}' />" >Show</a></td>
                <td><a href="<c:url value='/removepupil/${pupils.pupilId}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>
<%--<c:if test="${!empty pupils.books}">--%>
    <%--<table class="tg">--%>
        <%--<tr>--%>
            <%--<th width="80">Book ID</th>--%>
            <%--<th width="120">Book Name</th>--%>
            <%--<th width="120">Book Genre</th>--%>
            <%--<th width="120">Book Country</th>--%>
            <%--<th width="60">Delete</th>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${pupils.books}" var="books">--%>
            <%--<tr>--%>
                <%--<td>${books.bookId}</td>--%>
                <%--<td>${books.name}</td>--%>
                <%--<td>${books.genre}</td>--%>
                <%--<td>${books.country}</td>--%>
                <%--<td><a href="<c:url value='/removebook/${books.bookId}' />" >Delete</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
<%--</c:if>--%>
</body>
</html>
