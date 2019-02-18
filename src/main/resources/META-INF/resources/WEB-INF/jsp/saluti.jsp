<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Ciao <%= request.getSession().getAttribute("username")%> la soluzione era: <%= request.getSession().getAttribute("soluzione")%>
</body>
</html>
