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
<h2>Ciao ${user.nome} </h2>
<section class="title">
    <div class="titleContainer">
        <h1 class="firstTitle">Master Mind</h1>
    </div>
</section>
<div id="pageContainer">
    <div class="formContainer">
        <nav>
            <span id="showLogin" class="current">LOGIN</span>
        </nav>
        <form:form name="login" action="login" method="POST">
            <label for="usernameLogin">GIOCO</label>
            <input id="usernameLogin" type="text" name="name" />
            <label for="passwordLogin">Password</label>
            <input id="passwordLogin" type="password" name="password" /> <br />
            <input id="login" type="submit" value="login" />
        </form:form>
    </div>
</div>
</body>
</html>
