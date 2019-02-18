<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>MasterMind</title>
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
            <span id="showLogin" class="current">LOGIN</span>
        </nav>
        <form id="loginForm" method="post">
            <label for="usernameLogin">Username</label>
            <input id="usernameLogin" type="text" name="name" />
            <label for="passwordLogin">Password</label>
            <input id="passwordLogin" type="password" name="password" /> <br />
            <input id="login" type="submit" value="login" />
        </form>
    </div>
</div>
</body>
</html>
