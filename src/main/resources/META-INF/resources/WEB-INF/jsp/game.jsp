
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2>Ciao <%= request.getSession().getAttribute("username")%></h2>
    <br>
</head>
<body>
    <form action="<%=request.getContextPath()+"/Game" %>" method="get">
        <label for="numero1">Primo numero</label>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="number" name="numero1" min="0" max="9" step="1">
        <br>
        <label for="numero2">Secondo numero</label>
        <input type="number" name="numero2" min="0" max="9" step="1">
        <br>
        <label for="numero3">Terzo numero</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="number" name="numero3" min="0" max="9" step="1">
        <br>
        <br>
        <button type="submit" name="invia">Invia</button>
    </form>
</body>
</html>
