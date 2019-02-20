<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <title>Vittoria</title>
</head>
<body>

<h1>Mitico  **** ${nome} ****</h1>
<h2>Hai vinto</h2>
<h3>Ci hai messo --> ${tent} tentativi</h3>

<form action="/" method="post">
    <h1>Rigioca </h1>
    <input type="submit" class="button">
</form>


</body>
</html>