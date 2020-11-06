<%--
  Created by IntelliJ IDEA.
  User: Eugene
  Date: 05.11.2020
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <title>Main Page</title>

</head>
<body>


<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/
bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+
j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>



    <fieldset>

        <!-- Form Name -->
        <legend align="center">Выбирете действие</legend>


        <form action="/input-pageJsp">
            <!-- Button -->
            <div class="form-group" align="center">
                <label class="col-md-4 control-label" for="singlebutton1">Вход</label>
                <div class="col-md-4">
                    <button id="singlebutton1" name="singlebutton1" class="btn btn-primary">Button</button>
                </div>
            </div>
        </form>

        <form action="/registration-page">
            <!-- Button -->
            <div class="form-group" align="center">
                <label class="col-md-4 control-label" for="singlebutton3">Регистрация</label>
                <div class="col-md-4">
                    <button id="singlebutton3" name="singlebutton3" class="btn btn-primary">Button</button>
                </div>
            </div>
        </form>

        <form action="/error-page">
            <!-- Button -->
            <div class="form-group" align="center">
                <label class="col-md-4 control-label" for="singlebutton2">Просмотр сайта</label>
                <div class="col-md-4">
                    <button id="singlebutton2" name="singlebutton2" class="btn btn-primary">Button</button>
                </div>
            </div>
        </form>

    </fieldset>


</body>
</html>

