<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Личный кабинет</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/update.user.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div align="center">
<#include '../common/header.ftl'/>
    <h3>Заполните поле</h3>
    <label>Имя:</label>
    <input type="text" id="name" name="name" value="${model.user.name}" required/>
    <input type="text" id="email" name="email" value="${model.user.email}" hidden/>
    <input type="password" id="password" name="password" value="${model.user.password}" hidden/>
    <br>
    <button id="button" onclick="sendNewFields(
    ${model.user.id},
            document.getElementById('name').value,
            document.getElementById('email').value,
            document.getElementById('password').value
            )">Сохранить
    </button>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>