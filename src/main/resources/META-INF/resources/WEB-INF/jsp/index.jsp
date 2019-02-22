<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>MasterMind</title>
    <link href="css/mastermind.css" rel="stylesheet" type="text/css">
</head>
<body>
<section class="title">
    <div class="titleContainer">
        <h1 class="firstTitle">Master Mind</h1>
    </div>
</section>
<div id="pageContainer">
    <div class="formContainer">
        <nav>
            <span id="showLogin" class="current">Login o Registrati</span>
        </nav>
        <form:form name="login" method="POST">
            <label for="usernameLogin">Username</label>
            <input id="usernameLogin" type="text" name="nome" required="true" />
            <label for="passwordLogin">Password</label>
            <input id="passwordLogin" type="password" name="password" required="true" /> <br />
            <input id="login" type='submit' value='Login' onclick='this.form.action="login";' />
            <c:choose>
            <c:when test="${empty registrato}">
            <input id="signup" type='submit' value='Registrati' onclick='this.form.action="signup";' >
                </c:when>
                <c:otherwise>
                    <h3>grazie per esserti registrato ${registrato} ora puoi effettuare il login.</h3>
                </c:otherwise>
            </c:choose>
        </form:form>
        <c:choose>
            <c:when test="${loggedOut == 'notLogged'}">
                <h2>grazie per aver giocato!</h2>
            </c:when>
        </c:choose>
    </div>
</div>
</body>
</html>
