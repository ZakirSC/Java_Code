<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div>
<#include '../common/header.ftl'/>
            <h3>На Ваш email ${model.email} было отправлено письмо для подтверждения регистрации.</h3>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>