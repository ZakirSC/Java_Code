<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Поиск</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<#include '../common/header.ftl'/>
<#if model.fileInfoList??>
<h2 align="center">По Вашему запросу "${model.search}" было найдено:</h2>
<div>
    <table class="sort" align="center">
        <tr>
            <th>Название</th>
            <th>Описание</th>
            <th>Дата создания</th>
            <th>Открыть</th>
        </tr>
        <#list model.fileInfoList as file>
            <tr>
                <td>${file.originalName}</td>
                <td>${file.description}</td>
                <td>${file.uploadTime}</td>
                <td><a href="/open_file?id=${file.id}"><img src="../images/notepad.png"/></a></td>
            </tr>
        </#list>
    </table>
<#--<div><span></span>
    <a href="/open_file?id=${model.fileInfo.id}">${model.fileInfo.originalName}</a>
</div>-->
</div>
<#else>
<h2>По Вашему запросу "${model.search}" ничего не найдено.</h2>
</#if>
</body>
</html>