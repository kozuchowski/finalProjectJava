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

<div>
   <div>
       <h1>trening</h1>
       <a href="/login/back">Wróć</a>
       <a href="/login/logout">Wyloguj</a>
   </div>



    <c:if test="${training == null}">
        <h2>Nie masz jeszcze treningu</h2>
    </c:if>
    <c:if test="${training != null}">
        <h2>Ilość tygodni: ${training.exercises[0].weeksAmount}</h2>
        <div class="container">
            <table>
                <tr>
                    <th>Nazwa</th>
                    <th>Opis</th>
                    <th>Ciężar początkowy</th>
                    <th>progres ciężaru między seriami</th>
                    <th>Ilość serii</th>
                    <th>Ilość powtórzeń</th>
                </tr>
                <c:forEach items="${training.exercises}" var="exercise">
                    <c:if test="${exercise != null}">
                        <tr>
                            <td>${exercise.name}</td>
                            <td>${exercise.description}</td>
                            <td>${exercise.basicWeight}</td>
                            <td>${exercise.progress}</td>
                            <td>${exercise.seriesAmount}</td>
                            <td>${exercise.amount}</td>
                        </tr>
                    </c:if>

                </c:forEach>
            </table>
        </div>
    </c:if>
</div>

</body>
</html>
