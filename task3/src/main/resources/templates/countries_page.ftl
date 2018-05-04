<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>

<head><title>Тестовое задание</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
</head>


<body>
<div id="container">
    <div id="top"></div>
    <div id="left">
        <h2>Выберите страну</h2>
        <div class="hr">
            <hr/>
        </div>
        <p class="side">
            <select onchange="top.location=this.value">
            <#list model.countries as country>
                <option value="/countries?id=${country.id}&cityid=
            <#if country.id == 1>1</#if>
            <#if country.id == 2>11</#if>
            <#if country.id == 3>21</#if>
            <#if country.id == 4>31</#if>
            <#if country.id == 5>41</#if>"
                        <#if model.choice == country.id>selected</#if>>
                ${country.name}
                </option>
            </#list>
            </select>
        </p>
        <br/>
        <h2>Выберите город чтобы увидеть на карте</h2>
        <div class="hr">
            <hr/>
        </div>
    <p class="side"><#list model.cities as city>
        <p><a href="/countries?id=${city.country.id}&cityid=${city.id}">${city.name}</a></p>
    </#list>
        </p>
    </div>
    <div id="main">
        <form title="Поиск" action="/search" name="search" method="get">
            <input type="text" name="search" placeholder="введите имя города" onfocus="clearText(this)"
                   onblur="clearText(this)">
            <button type="submit">поиск</button>
        </form>
        <h1>Город на карте: ${model.city.name}</h1>
        <p>${model.city.urlMap}</p>
        <div class="clear"></div>
    </div>
    <div id="footer"></div>

</div>
<div style="font-size: 0.8em; text-align: center; margin-top: 1em; margin-bottom: 1em;">
    Тестовое задание Бурнаева Закира
</div>
</body>
</html>