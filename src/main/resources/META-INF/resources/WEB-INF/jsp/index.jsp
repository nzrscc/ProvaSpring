<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <title>MasterMind</title>
</head>
<body>

    <form class="indo" action="/user" method="post">
        <h1>Benvenuto in MasterMind </h1>
        <label>Inserisci il tuo nome</label>
        <input id="nome_user" name="nome_user" value="">
        <input type="submit" class="button">
    </form>

</body>
</html>
