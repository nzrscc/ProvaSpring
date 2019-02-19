<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>saaa</title>
</head>
<body >
<center>

    dio è una bella persona <br>
    ma tu <%=session.getAttribute("nome_user")%> sei più bravo di lui
</center>


</body>
</html>