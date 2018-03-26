<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Подтверждение аккаунта</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div>
<#include '../common/header.ftl'/>
        <#if model.result == true>
            <h3>Вы успешно подтвердили Ваш аккаунт. Теперь можете войти на сайт под своим логином и паролем</h3>
        <#else>
            <h3>Ссылка не верна, либо истекло 3 часа после регистрации.</h3>
        </#if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>