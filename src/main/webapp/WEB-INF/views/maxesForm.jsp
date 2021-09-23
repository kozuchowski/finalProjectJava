<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 15/09/2021
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        <a href="/login/back">Wróć</a>
        <a href="/login/logout">Wyloguj</a>
        <h1>formularz do maxów</h1>
    </div>

    <div class="container">
        <form method="post" action="/training/usermaxes">
            <label>Martwy ciąg<input type="number" name="deadlift"></label>
            <label>Przysiad<input type="number" name="squat"></label>
            <label>Wyciskanie sztangi<input type="number" name="benchpress"></label>

            <select name="trainerLogin">
                <c:forEach items="${users}" var="user">
                    <option>
                            ${user.login}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Prześlij">

        </form>
    </div>
</div>

</body>
</html>
