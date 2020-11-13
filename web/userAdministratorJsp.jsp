<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 26.10.2020
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Admin page</title>
    <style type="text/css">
        body {
            font: 0.8em Arial, Helvetica, sans-serif; /* Шрифт на веб-странице */
            background: #D7E1F2; /* Цвет фона */
            color: #ffe; /* Цвет текста */
        }

        a {
            color: #008BCE; /* Цвет ссылок */
        }

        #container {
            width: 1500px; /* Ширина макета */
            margin: 0 auto; /* Выравниваем по центру */
            background: #1E90FF; /* Цвет колонок */
        }

        #header {
            font-size: 2.2em; /* Размер текста */
            text-align: center; /* Выравнивание по центру */
            padding: 5px; /* Отступы вокруг текста */
            background: #D71920; /* Цвет фона шапки */
        }

        #nav, #aside {
            float: left;
            width: 110px;
            padding: 5px;
        }
        #aside {
            width: 190px; /* Ширина правой колонки */
            float: right;
        }

        #content {
            background: #DEB887;
            margin: 0 200px; /* Ширина колонок */
            padding: 230px;/*Длина колонки*/
        }

        #aside {
            float: right;
            color: white;
        }

        h2 {
            margin: 0 0 1em;
        }

        #footer {
            clear: both; /* Отменяем действие float */
            padding: 5px; /* Отступы вокруг текста */
            background: #D71920; /* Цвет фона подвала */
        }

        /*Кнопка All Car*/

        {background: url(https://html5book.ru/wp-content/uploads/2015/07/background39.png);}
        a {
            text-decoration: none;
            outline: none;
            display: inline-block;
            width: 140px;
            height: 45px;
            line-height: 45px;
            border-radius: 45px;
            margin: 10px 20px;
            font-family: 'Montserrat', sans-serif;
            font-size: 11px;
            text-transform: uppercase;
            text-align: center;
            letter-spacing: 3px;
            font-weight: 600;
            color: #524f4e;
            background: white;
            box-shadow: 0 8px 15px rgba(0,0,0,.1);
            transition: .3s;
        }
        a:hover {
            background: #2EE59D;
            box-shadow: 0 15px 20px rgba(46,229,157,.4);
            color: white;
            transform: translateY(-7px);
        }



    </style>
</head>
<body>
<div id="container">
    <div id="header">Auto Rental Administrator Page (User)</div>

    <div id="nav">
        <br>
        <p><h1>Создать пользователя/администр.</h1>
        <form method="post" action="/user-registration">
             <input id="idR" name="idR"> id
           <br/>
           <br/>
            <input id="loginR" name="loginR"> login
            <br/>
            <br/>
            <input id="passwordR" name="passwordR"> password
            <br/>
            <br/>
            <button type="submit">Registration user</button>
            <hr align="center" width="190" size="1" color="#ff0000" />
        </form>
        <br>


        <h1>Удалить пользователя</h1>
        <form method="post" action="/user-delete">
            <input id="loginD" name="loginD"> login
            <br/>
            <br/>
            <input id="passwordD" name="passwordD"> password
            <br/>
            <button type="submit">Delete user</button>
        </form>
        </p>
    </div>


    <div id="aside">
        <p align="right"><h1 >Посик пользователя по ID</h1>
        <form method="get" action="/user-searchID">
            <input id="idS" name="idS"> id
            <br/>
            <br/>
            <button type="submit">Search user id</button>
            <hr align="center" width="190" size="1" color="#ff0000" />
        </form>
        <br>
        <h1 >Поиск пользователя
            (вход) по
            логин и пароль</h1>
        <form method="post" action="/user-input">
            <input id="login" name="login"> login
            <br/>
            <input id="password" name="password"> password
            <br/>
            <br/>
            <button type="submit">Input</button>
            <hr align="center" width="190" size="1" color="#ff0000" />
        </form>

        </p>
    </div>

    <div id="content">

        <form method="post" action="/changer-user">
            <input id="loginC" name="loginC"> login
            <br/>
            <input id="passwordC" name="passwordC"> password
            <br/>
            <br/>
            <button type="submit">Изменить пароль</button>
            <br/>
            <br/>
        </form>

        <form  method="get" action="/user-all">
            <a align="center" href="/user-all">All User</a>
        </form>

    </div>

    <div id="footer">&copy; Евгений Юджин</div>
</div>

</body>
</html>
</head>
<body>

</body>
</html>
