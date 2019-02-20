<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>MasterMind</title>
</head>
<body>
<section class="title">
    <div class="titleContainer">
        <h1 class="firstTitle">Benvenuto in Master Mind ${currentUser.nome}</h1>
    </div>
</section>
<div id="pageContainer">
    <div class="formContainer">
        <form:form action="" method="get">
            <label for="num1">Primo numero</label>&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="num1" type="number" name="numero1" min="0" max="9" step="1">
            <br>
            <label for="num2">Secondo numero</label>
            <input id="num2" type="number" name="numero2" min="0" max="9" step="1">
            <br>
            <label for="num3">Terzo numero</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="num3"type="number" name="numero3" min="0" max="9" step="1">
            <br>
            <br>
            <button type="submit" name="invia">Invia</button>
        </form:form>
    </div>

    <div>
        <form:form action="logout" method="get">
        <button type="submit" name="logout">logout</button>
        </form:form>
    </div>
</div>
</body>
</html>
