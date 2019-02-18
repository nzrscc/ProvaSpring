<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
I numeri che hai inserito sono: <%= request.getAttribute("input")%>
<br><br>
Posizione corretta: <%= request.getAttribute("PosEsa")%>
<br>
Posizione sbagliata: <%= request.getAttribute("PosErr")%>
<br> <br> <br>
Tentativi rimasti: <%= request.getSession().getAttribute("tentativi")%>
<br><br>
    <form action="<%=request.getContextPath()+"/Game" %>" method="post">
        Si vuole riprovare?
        <select name="scelta">
        <option name="SI">SI</option>
        <option name="NO">NO</option>
        </select>
        <br><br>
        <button type="submit" name="invia">Invia</button>
    </form>

</body>
</html>
