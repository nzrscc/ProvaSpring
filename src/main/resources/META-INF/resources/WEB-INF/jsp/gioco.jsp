<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gioco Master Mind</title>
</head>
<body>

<%--<h1>Benvenuto <%= session.getAttribute("nome_user") %> in MasterMIND!</h1>--%>
<h1>Benvenuto ${nome}  in MasterMIND!</h1>
<h2>Il gioco abbia inizio: Trova la combinazione segreta</h2>
<form  class="form" action="/tenta" method="post">
    <p>
        <input style="background-color: cornflowerblue" id="tent_num1" type="number" min="0" max="9"  name="tent_num1" value="0"> <br>
        <input style="background-color: coral" id="tent_num2" type="number" min="0" max="9"  name="tent_num2" value="0"> <br>
        <input style="background-color: darkgreen" id="tent_num3" type="number" min="0" max="9"  name="tent_num3" value="0"> <br>
        <input style="background-color: red" type="submit">
        <br>
        <label>Posizione Giusta: ${pos_n} </label>
        <br>
        <label>Numeri Corretti: ${giu_n} </label>
        <br>
        <label>Tentativi rimasti: ${tent} </label>
    <br>

    </p>
</form>

<label>( ${tent_num1}  -- </label>
<label> ${tent_num2} -- </label>
<label> ${tent_num3} )</label>
</body>