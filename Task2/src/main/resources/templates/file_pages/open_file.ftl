<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Файл</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<#include '../common/header.ftl'/>
<h1 align="center">Содержание файла: </h1>
    <p align="center">
        ${model.text}
    </p>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>