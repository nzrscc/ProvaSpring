<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 14/02/2019
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ERRORE NEL SALVATAGGIO DELL'UTENTE</h1>
<h2> utente non salvato: <%= request.getSession().getAttribute("username") %></h2>

</body>
</html>
