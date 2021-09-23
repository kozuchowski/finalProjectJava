<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 13/09/2021
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <style><%@include file="/WEB-INF/css/index.css"%></style>
</head>
<body>

<h1>${passError}</h1>
<h1>${loginError}</h1>

<div class="container">
    <form action="/signin/check" method="post">

        <label>Login<input type="text" name="login"></label>
        <label>Password<input type="password" name="pass"></label>
        <label>Confirm password<input type="password" name="confirm"></label>
        <label>User<input type="radio" name="role" value="u" checked></label>
        <label>Trainer<input type="radio" name="role" value="t"></label>

        <input type="submit" value="Sign In">

    </form>
</div>

</body>
</html>
