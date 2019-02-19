<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
    <title>Gioco Master Mind</title>
</head>
<body>

<h1>Benvenuto <%= session.getAttribute("nome") %> in MasterMIND!</h1>
<h2>Il gioco abbia inizio: Trova la combinazione segreta</h2>
<form action="tenta" method="post">
    <p>
        <input style="background-color: cornflowerblue" id="tent_num1" type="number" min="0" max="9"  name="tent_num1" value="0"> <br>
        <input style="background-color: coral" id="tent_num2" type="number" min="0" max="9"  name="tent_num2" value="0"> <br>
        <input style="background-color: darkgreen" id="tent_num3" type="number" min="0" max="9"  name="tent_num3" value="0"> <br>
        <input style="background-color: red" type="submit">
        <br>
        <label>Posizione Giusta: <%= request.getAttribute("pos_n")%></label>
        <br>
        <label>Numeri Corretti: <%= request.getAttribute("giu_n")%></label>
        <br>
        <label>Tentativi rimasti: <%= request.getAttribute("tent")%></label>
    </p>
</form>

<label><%= session.getAttribute("nome") %></label>
<label><%= request.getParameter("tent_num1")%></label>
<label><%= request.getParameter("tent_num2")%></label>
<label><%= request.getParameter("tent_num3")%></label>
</body>