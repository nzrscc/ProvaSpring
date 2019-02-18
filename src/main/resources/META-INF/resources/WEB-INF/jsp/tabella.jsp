<%--
  Created by IntelliJ IDEA.
  User: utente
  Date: 14/02/2019
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@page import="it.javaBean.UserBean"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Tabella</title>
    <%----<link href="css/StyleSheet.css" rel="stylesheet" type="text/css"> --%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<h2 align="center">HTML Table</h2>

<div>
    <table class="table table-striped table-bordered">
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Punteggio</th>
        </tr>
        <c:forEach var="element" items="${listaUser.utenti}">
        <tr>
                <td>${element.id}</td>
                <td>${element.nome}</td>
                <td>${element.punteggio}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
