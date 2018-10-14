<%@ page import="mainpackage.dao.PupilsDAO" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="Search" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11.10.2018
  Time: 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Search</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3>Search entry</h3>--%>
<%--<a href="/search_pupil_by_name?str=search_pupil_by_name">--%>
    <%--search_pupil_by_name--%>
<%--</a>--%>

<html>
<head><title>Search Entry</title></head>
<body>
<form action="/search_pupil_by_name" method="post">
    First name: <input type="text" name="str"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

