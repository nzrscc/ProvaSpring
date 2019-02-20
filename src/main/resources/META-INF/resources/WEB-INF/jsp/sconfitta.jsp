<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <title>Sconfitta</title>
</head>
<body>

<h2>Sei stato sconfitto dal  <h1>masterBRAIN</h1> **** ${nome} ****</h2>

<h3>Puoi riprovare, oppure dichiarare la mia superiorità!</h3>

<form action="/" method="post">
    <h1>Gioca ancora</h1>
    <input type="submit" class="button">
</form>




</body>
</html>