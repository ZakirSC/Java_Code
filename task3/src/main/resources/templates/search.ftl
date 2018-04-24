<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>

<head><title>Тестовое задание</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
</head>


<body>
<div id="container">
<#if model.cityByName??>
    <div id="top"></div>
    <div id="left">
        <h2>Выберите страну</h2>
        <div class="hr">
            <hr/>
        </div>
        <p class="side">
        <a href="/countries">Вернуться на главную страницу</a>
        </p>
        <br/>
        <h2>

        </h2>
        <div class="hr">
            <hr/>
        </div>
    <p class="side">

    </p>
    </div>
    <div id="main">
        <form title="Поиск" action="/search" name="search" method="get">
            <input type="text" name="search" placeholder="введите имя города" onfocus="clearText(this)"
                   onblur="clearText(this)">
            <button type="submit">поиск</button></form>
        <h1>Город на карте: ${model.cityByName.name}</h1>
        <p>${model.cityByName.urlMap}</p>
        <div class="clear"></div>
    </div>
    <div id="footer"></div>
<#else>
    <h2>По Вашему запросу "${model.search}" ничего не найдено.</h2>
    <a href="/countries">Вернуться на главную страницу</a>
</#if>
</div>
<div style="font-size: 0.8em; text-align: center; margin-top: 1em; margin-bottom: 1em;">
    Тестовое задание Бурнаева Закира</div>
</body>
</html>