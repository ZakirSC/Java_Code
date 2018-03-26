<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Вход</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div align="center">
<#include '../common/header.ftl'/>
    <h1>Введите email и пароль</h1>
<#if model.error == true>
    <h2>Неверно введены имя пользователя или пароль</h2>
</#if>
    <form title="Вход"
          name="registrationForm"
          method="post"
          action="/login">
        <label>Введите Ваш email:</label>
        <input type="text" name="email" placeholder="Почта"/>
        <label>Введите Ваш пароль:</label>
        <input type="password" name="password" placeholder="Пароль"/>
        <br>
        <input type="checkbox" name="remember-me"> Запомнить
        <br>
        <input id="button" type="submit" value="Войти">
    </form>
    <p><a id="button" href="/registration">Зарегистрироваться</a></p>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>