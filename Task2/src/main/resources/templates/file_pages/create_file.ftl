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
<div align="center">
<form title="Создание файла"
      name="createForm"
      method="post"
      action="/create_file">
    <label>Введите название файла: </label>
    <input type="text" name="name" placeholder="Название" required/>
    <label>Введите описание файла: </label>
    <input type="text" name="description" placeholder="Описание" required/>
    <div>
    <label>Введите содержание: </label>
    <input name="text" placeholder="Содержание" required/>
    </div>
    <br>
    <input id="button" type="submit" value="Создать"/>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</div>
</body>
</html>