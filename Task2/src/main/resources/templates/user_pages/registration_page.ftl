<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Регистрация пользователя</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div>
<#include '../common/header.ftl'/>
    <h1>Регистрация</h1>
    <form title="Регистрация"
          name="registrationForm"
          method="post"
          action="/registration">
        <label>Введите Ваше имя:</label>
        <input type="text" name="name" placeholder="Имя" required/>
        <label>Введите Вашу почту:</label>
        <input type="text" name="email" placeholder="Почта" required/>
        <label>Введите Ваш пароль:</label>
        <input type="password" name="password" placeholder="Пароль" required/>
        <br>
        <input id="button" type="submit" value="Зарегистрироваться"/>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>