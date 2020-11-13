<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 16.10.2020
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Auto Rental Jsp</title>
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
            background: #FCE600; /* Цвет колонок */
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
            background: #54B948;
            margin: 0 200px; /* Ширина колонок */
            padding: 170px;/*Длина колонки*/
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
    <div id="header">Auto Rental Administrator Page</div>

    <div id="nav">
        <br>
        <p><h1>Добавить автомобиль</h1>
        <form method="post" action="/car-create">
          <!--  <input id="id" name="id"> id
            <br/>
            <br/> -->
            <input id="model" name="model"> model
            <br/>
            <br/>
            <input id="type" name="type"> type
            <br/>
            <br/>
          <button type="submit">Create car</button>
        <hr align="center" width="190" size="1" color="#ff0000" />
        </form>
<br>
        <h1>Удалить автомобиль</h1>
        <form method="post" action="/car-delete">
            <input id="idDel" name="idDel"> id
            <br/>
            <br/>
            <input id="modelDel" name="modelDel"> model
            <br/>
            <br/>
            <input id="typeDel" name="typeDel"> type
            <br/>
            <br/>
            <button type="submit">Delete car</button>
        </form>
        </p>
    </div>


    <div id="aside">
        <p align="right"><h1 >Посик автомобиля по ID</h1>
        <form method="get" action="/car-searchID">
            <input id="idS" name="idS"> id
            <br/>
            <br/>
            <button type="submit">Search car id</button>
            <hr align="center" width="190" size="1" color="#ff0000" />
        </form>
        <br>
        <h1 >Посик автомобиля по параметрам</h1>
        <form method="get" action="/car-search-two-param">
            <input id="modelP" name="modelP"> model
            <br/>
            <input id="typeP" name="typeP"> type
            <br/>
            <br/>
            <button type="submit">Search car two param</button>
            <hr align="center" width="190" size="1" color="#ff0000" />
        </form>



        </p>
    </div>

    <div id="content">

        </form>
        <br>
        <h1 >Изменение параметров
            автомобиля</h1>
        <form method="post" action="/changer-car">
            <input id="idC" name="idC"> id
            <br/>
            <br/>
            <input id="modelC" name="modelC"> model
            <br/>
            <br/>
            <input id="typeC" name="typeC"> type
            <br/>
            <br/>
            <button type="submit">Changer car</button>
        </form>
        <br/>
           <form  method="get" action="/car-all">
                <a align="center" href="/car-all">All Car</a>
                </form>

    </div>

    <div id="footer">&copy; Евгений Юджин</div>
</div>

</body>
</html>
