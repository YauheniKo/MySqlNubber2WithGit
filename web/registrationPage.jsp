<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 05.11.2020
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация нового пользователя</title>
</head>
<body>
<h1 >Вход</h1>
<form method="post" action="/user-registration">
    <input id="login" name="login"> login
    <br/>
    <input id="password" name="password"> password
    <br/>
    <br/>
    <button type="submit">Регистрация</button>
    <hr align="center" width="190" size="1" color="#ff0000" />

</form>
</body>
</html>
