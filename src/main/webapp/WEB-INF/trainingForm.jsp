<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 15/09/2021
  Time: 07:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dodaj ćwiczenia</h2>

<form method="post" action="/training/saveTraining">
    <input type="text" value="${login}" name="login" hidden>
    <label>Nazwa ćwiczenia<input type="text" name="name"></label>
    <label>Opis ćwiczenia<input type="textarea" name="description"></label>
    <label>Ciężar początkowy<input type="number" name="weight"></label>
    <label>Progres między seriami<input type="number" name="progress"></label>
    <label>Ilość serii<input type="number" name="series"></label>
    <label>Ilość powtórzeń<input type="number" name="amount"></label>
    <label>Ilość tygodni<input type="number" name="weeks"></label>

    <input type="submit" value="Zapisz">
</form>

</body>
</html>
