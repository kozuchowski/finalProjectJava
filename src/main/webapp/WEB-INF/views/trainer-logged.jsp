<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 14/09/2021
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="menu">
        <h1>trainer</h1>
        <a href="/login/logout">Wyloguj</a>
    </div>
    <h2>Użytkownicy czekający na trening</h2>
    <c:if test="${users == null}">
        <h1>Nie ma nikogo do wyświetlenia</h1>
    </c:if>

    <div class="content">
        <table>
            <c:forEach items="${users}" var="user">
                <c:if test="${user.training.id == null || user.waitingForTraining}">
                    <tr>
                        <td><a href="/training/create?login=${user.login}"> ${user.login}</a></td>
                    </tr>
                    <tr>
                        <td>Martwy ciąg: ${user.deadlift}</td>
                        <td>Przysiad: ${user.squat}</td>
                        <td>Wyciskanie sztangi: ${user.benchpress}</td>
                    </tr>
                </c:if>


            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
