<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>MasterMind</title>
</head>
<body >
<center>

    dio è una bella persona
    <form action="/user" method="post">
        <h1>ProvaPoteri </h1>
        <label>Inserisci il suo nome</label>
        <input style= "background-color: lemonchiffon" id="nome_user" name="nome_user" value="">
        <input type="submit" class="button">
    </form>
    <%=session.getAttribute("nome_user")%>
</center>


</body>
</html>
