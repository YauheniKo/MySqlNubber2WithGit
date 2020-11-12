<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 22.10.2020
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Error page</title>
</head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

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
    <legend align="center">Error page</legend>

    <h1 align="center">Призошла ошибка(некорректный ввод) </h1>

    <!-- Button -->
    <form action="/main-page">
        <!-- Button -->
        <div class="form-group" align="center">
            <div class="col-md-4">
                <button id="singlebutton1" name="singlebutton1" class="btn btn-primary">Главная страница</button>
            </div>
        </div>
    </form>

</fieldset>

</body>
</html>
