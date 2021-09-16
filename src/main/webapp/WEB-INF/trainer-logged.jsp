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
    <h1>trainer</h1>
    <h2>Tutaj wyświetl użytkowników oczekujących na trening</h2>


    <table>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><a href="/training/create?login=${user.login}"> ${user.login}</a></td>
            </tr>
            <tr>
                <td>Martwy ciąg: ${user.deadlift}</td>
                <td>Przysiad: ${user.squat}</td>
                <td>Wyciskanie sztangi: ${user.benchpress}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
