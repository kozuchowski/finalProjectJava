<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 15/09/2021
  Time: 09:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>trening</h1>

<a href="/login/back">Wróć</a>
<a href="/login/form">Wyloguj</a>
<c:if test="${training == null}">
    <h2>Nie masz jeszcze treningu</h2>
</c:if>
    <table>
        <c:forEach items="${training.exercises}" var="exercise">
            <c:if test="${exercise != null}">
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td>${exercise.name}</td>
                </tr>
            </c:if>

        </c:forEach>
    </table>

</body>
</html>
