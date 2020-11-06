<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 05.11.2020
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <style>
        body {
            font-family: Arial;
            color: white;
        }

        .split {
            height: 100%;
            width: 50%;
            position: fixed;
            z-index: 1;
            top: 0;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .left {
            left: 0;
            background-color: #111;
        }

        .right {
            right: 0;
            background-color: red;
        }

        .centered {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
        }

        .centered img {
            width: 150px;
            border-radius: 50%;
        }
    </style>
</head>
<body>

<div class="split left">
    <div class="centered">
        <img src="img_avatar2.png" alt="Avatar woman">
        <h2>HTML CSS</h2>
        <p>Some text.</p>
    </div>
</div>

<div class="split right">
    <div class="centered">
        <h1 >Вход/регистация</h1>
        <form method="post" action="/user-input">
            <p align="left">  <input id="login" name="login"> login  </p>

            <p align="left"> <input id="password" name="password"> password  </p>

            <p align="left">   <button type="submit">Вход</button> </p>


            <p align="left"> <p align="left">  <input type="button" value="регистрация" onclick='location.href="http://localhost:8080/"+
            "registration-page"'>
             </p>

        </form>

    </div>
</div>

</body>
</html>

