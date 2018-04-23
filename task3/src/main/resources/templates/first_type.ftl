<#--
<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Страны</title>

</head>
<body>
<table align="center">
    <thead>
    <tr>
        <th>Страна</th>
    </tr>
    </thead>
    <tbody>
    <#list model.countries as country>
    <tr>
        <td>
        ${country.name}
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>-->
