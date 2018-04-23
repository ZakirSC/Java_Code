<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <title>Страны</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/getcities.js"></script>

</head>
<body>
<div style="float: left;">
    <select onchange="top.location=this.value">
    <#list model.countries as country>
        <option value="/countries?id=${country.id}&cityid=<#if country.id == 1>1</#if>
<#if country.id == 2>11</#if><#if country.id == 3>21</#if><#if country.id == 4>31</#if>
<#if country.id == 5>41</#if>" <#if model.choice == country.id>selected</#if>>
            ${country.name}
        </option>
    </#list>
    </select>
</div>
<div id="cities" style="float: left;">
    <#list model.cities as city>
          <p><a href="/countries?id=${city.country.id}&cityid=${city.id}">${city.name}</a></p>
    </#list>
</div>
<div id="map" style="float: left;">
    ${model.city.urlMap}
</div>
</body>
</html>