<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Complimenti <%= request.getSession().getAttribute("username") %>. Hai vinto!! </h1>
</body>
</html>
