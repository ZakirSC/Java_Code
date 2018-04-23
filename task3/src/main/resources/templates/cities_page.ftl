<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Города</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.simplePagination.js"></script>
    <script>

    </script>
</head>
<body>
<table align="left">
    <thead>
    <tr>
        <th>Городa</th>
    </tr>
    </thead>
    <tbody>
    <div id="selector">
    <#list model.cities as city>
        <tr>
            <td>
            ${city.name}
            </td>
        </tr>
    </#list>
    </div>


    </tbody>
</table>
</body>
</html>