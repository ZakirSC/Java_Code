<#ftl encoding='UTF-8'>
<#import '/spring.ftl' as spring>
<@spring.bind "model"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Выбор автомобиля</title>
    <meta name="keywords" content="shoes store, free template, ecommerce, online shop, website templates, CSS, HTML" />
    <meta name="description" content="Shoes Store is a free ecommerce template provided by templatemo.com" />
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet" href="../css/nivo-slider.css" type="text/css" media="screen" />

    <link rel="stylesheet" type="text/css" href="../css/ddsmoothmenu.css" />

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/ddsmoothmenu.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/updateUser.js"></script>

    <script type="text/javascript">

        ddsmoothmenu.init({
            mainmenuid: "top_nav", //menu DIV id
            orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
            classname: 'ddsmoothmenu', //class added to menu's outer DIV
            //customtheme: ["#1c5a80", "#18374a"],
            contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
        })

    </script>

</head>

<body>

<div id="templatemo_body_wrapper">
    <div id="templatemo_wrapper">

        <div id="templatemo_header">
            <div id="site_title"><h1><a href="/">Car market</a></h1></div>
            <div id="header_right">
                <p>
                <#if model.user??>
                    <a href="/profile">Profile</a> |
                    <a href="/bucket">Bucket</a> |
                    <a href="/logout">Logout</a> |
                <#else>
                    <a href="/login">Вход</a>
                    <a href="/registration">Регистрация</a>
                </#if>
            </div>
            <div class="cleaner"></div>
        </div>  <!-- END of templatemo_header -->

        <div id="templatemo_menubar">
            <div id="top_nav" class="ddsmoothmenu">
                <ul>
                    <li><a href="/" class="selected">Home page</a></li>

                </ul>
                <br style="clear: left" />
            </div> <!-- end of ddsmoothmenu -->
            <div>

            </div>
        </div> <!-- END of templatemo_menubar -->

        <div id="templatemo_main">
            <div id="sidebar" class="float_l">
                <div class="sidebar_box"><span class="bottom"></span>
                    <h3>Марки</h3>
                    <div class="content">
                        <ul class="sidebar_list">
                            <li class="first"><a href="/marka?id=3">BMW</a></li>
                            <li><a href="marka?id=1">Audi</a></li>
                            <li><a href="marka?id=2">VW</a></li>
                            <li><a href="#">Kia</a></li>
                            <li><a href="#">Honda</a></li>
                            <li><a href="#">Lada</a></li>
                            <li class="last"><a href="#">Ford</a></li>
                        </ul>
                    </div>
                </div>
                <div class="sidebar_box"><span class="bottom"></span>
                    <div class="content">
                        <div class="bs_box">

                        </div>
                        <div class="bs_box">

                        </div>
                        <div class="bs_box">

                        </div>
                        <div class="bs_box">

                        </div>
                    </div>
                </div>
            </div>
            <div id="content" class="float_r">
                <div>
                    <div>

                    </div>
                    <div id="htmlcaption" class="nivo-html-caption">
                    </div>
                </div>
                <h1>На Ваш email ${model.email} было отправлено письмо для подтверждения регистрации.</h1>
            </div>
            <div class="cleaner"></div>
        </div> <!-- END of templatemo_main -->

        <div id="templatemo_footer">
            <p><a href="/">Home</a>
            </p>

            Copyright © 2018 <a href="#">Burnaev company</a> | <a>Car market</a> by <a>Zakir</a>
        </div> <!-- END of templatemo_footer -->

    </div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->


<script type='text/javascript' src='js/logging.js'></script>
</body>
</html>
