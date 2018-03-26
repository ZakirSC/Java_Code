<div align="right" id="header">
    <p>
    <#if model.user??>
        <a href="/profile">Личный кабинет</a><span> | </span>
        <a href="/logout">Выйти</a></a><span> | </span>
        <a href="/files">Все файлы</a></a><span> | </span>
        <a href="/create_file">Создать файл</a></a><span> | </span>
        <form title="Поиск" action="/search" name="search" method="get">
            <input type="text" name="search" placeholder="Имя файла" onfocus="clearText(this)"
                   onblur="clearText(this)">
            <button type="submit"><img src="../images/search.png"></button></form>
    <#else>
        <a href="/login">Вход</a><span> | </span>
        <a href="/registration">Регистрация</a>
    </#if>
    </p>

</div>