<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>

<h1>${error}</h1>

<form action="/login/check" method="post">

    <label>Login<input type="text" name="login"></label>
    <label>Password<input type="password" name="pass"></label>
    <input type="submit" value="sign In">

</form>

</body>
</html>
