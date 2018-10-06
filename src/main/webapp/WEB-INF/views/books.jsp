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
    Add a Book
</h1>
<c:url var="addAction" value="/book/add" ></c:url>
<form:form action="${addAction}" commandName="books">
    <table>
        <c:if test="${!empty books.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="bookId" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="bookId" />
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
                <form:label path="author">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="author" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="genre">
                    <spring:message text="Genre"/>
                </form:label>
            </td>
            <td>
                <form:input path="genre" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="country">
                    <spring:message text="Country"/>
                </form:label>
            </td>
            <td>
                <form:input path="country" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${empty books.name}">
                    <input type="submit"
                           value="<spring:message text="Add Book"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>
<h3>Books List</h3>
<c:if test="${!empty listBooks}">
    <table class="tg">
        <tr>
            <th width="80">Book ID</th>
            <th width="120">Book Name</th>
            <th width="120">Author</th>
            <th width="120">Book Genre</th>
            <th width="120">Book Country</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="books">
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
