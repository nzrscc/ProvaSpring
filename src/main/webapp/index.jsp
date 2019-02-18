<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <h1>Benvenuto su Master Mind!</h1>
</head>
<body>
<%--<form action="<%=request.getContextPath()+"/Start" %>" method="get">
    <label for="username">Username: </label>
    <input type="text" name="username" value="">
    <br><br><br>
    <button type="submit" name="invia">Invia</button>
</form>--%>

<form action="<%=request.getContextPath()+"/login" %>" method="get">
    <label for="username">Username: </label>
    <input type="text" name="username" value="">
    <label for="password">Password: </label>
    <input type="password" name="password" value="">
    <button type="submit" name="login">Login</button>
</form>


<br><br>
    <a href="<%=request.getContextPath()%>/Start?Classifica=utente"> Visualizza Classifica Utente</a>


<%--<form action="<%=request.getContextPath()+"/Classifica" %>" method="get">
    <button type="submit" name="ClassificaUtente">ClassificaUtente</button>
    <button type="submit" name="ClassificaTentativo">ClassificaTentativo</button>
</form>--%>

<%--<form action="<%=request.getContextPath()+"/Game" %>" method="get">
    <button type="submit" name="creaTabella">CreaTabella</button>
</form>--%>
</body>
</html>
