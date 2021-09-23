<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style><%@include file="/WEB-INF/css/index.css"%></style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>

<h1 style="color: azure">${error}</h1>

<div class="container">
    <form action="/login/check" method="post">

        <label>Login<input type="text" name="login"></label>
        <label>Password<input type="password" name="pass"></label>
        <input type="submit" value="Log In">

    </form>
</div>

</body>
</html>
