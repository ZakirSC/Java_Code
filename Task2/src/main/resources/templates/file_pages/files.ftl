<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Файлы</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<#include '../common/header.ftl'/>
<form style="text-align: right" title="Сортировка" action="/files" id="sort" name="sort" method="get">
    <select name="sort" onchange="document.getElementById('sort').submit()">
        <option value="NAME_UP" <#if model.sorted = 'NAME_UP'>selected</#if>>По названию▲</option>
        <option value="NAME_DOWN" <#if model.sorted = 'NAME_DOWN'>selected</#if>>По названию▼</option>
        <option value="TIME_UP" <#if model.sorted = 'TIME_UP'>selected</#if>>По времени добавления▲</option>
        <option value="TIME_DOWN" <#if model.sorted = 'TIME_DOWN'>selected</#if>>По времени добавления▼</option>
    </select></form>
<div>
    <table class="sort" align="center">
        <thead>
        <tr>
            <th>Название</th>
            <th>Описание</th>
            <th>Дата создания</th>
            <th>Открыть</th>
            <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <#list model.files as file>
        <tr>
            <td>${file.originalName}</td>
            <td>${file.description}</td>
            <td>${file.uploadTime}</td>
            <td><a href="/open_file?id=${file.id}"><img src="../images/notepad.png"/></a></td>
            <td>
                <form method="POST" action="/delete_file?id=${file.id}">
                    <input type="hidden" name="id" value="${file.id}"/>
                    <button type="submit">
                        <img src="../images/delete.png">
                    </button>
                    <#--<input type="submit" value="Удалить файл"/>-->
                </form>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>