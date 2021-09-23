<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 14/09/2021
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<style><%@include file="/WEB-INF/css/logged.css"%></style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div class="container">
<div class="menu">
    <p>user</p>
    <a href="/login/logout">Wyloguj</a>
</div>
    <div class="links">
        <a href="/training/check">Sprawdź trening</a>
        <a href="/training/usermaxes-form">Podaj maksymalne udźwigi</a>
    </div>
</div>

</body>
</html>
