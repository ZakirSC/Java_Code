<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Личный кабинет</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div align="center">
<#include '../common/header.ftl'/>
    <div>
        <h1>Личный кабинет</h1>
        <p><b>Имя: </b>${model.user.name}</p>
        <p><b>Email: </b>${model.user.email}</p>
        <p><b>Дата регистрации: </b>${model.user.registrationTime?datetime.iso?string("HH:mm dd.MM.yyyy")}</p>
        <p><a id="button" href="/update_profile?id=${model.user.id}">Редактировать</a></p>
        <hr/>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>