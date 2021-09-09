<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>index</title>
    <style>
        strong.text-title {
            font-size: larger;
            line-height: 50px;
        }

        a.btn-title {
            margin-top: 30px;
        }

        div.nav-footer {
            margin-bottom: 20px;
        }

        a.text-left {
            margin-bottom: 15px;
        }

        div.container-content {
            margin-top: 25px;
            margin-bottom: 25px;

        }

        body.mobile-body {
            background-color: rgb(236, 236, 236);
        }

        button.category-btn {
            margin-bottom: 5px;
            margin-right: 2px;

        }

        a.btn-searchkey {
            margin-bottom: 5px;
            margin-right: 2px;
        }

        div.thumbnail {
            padding: 0px;
            position: relative;
        }

        div.well1 {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;

        }

        div.has-feedback {
            position: relative;

        }


        @media screen and (max-width: 768px) {
            div.btn-searchxs {
                margin-left: 90px;
            }

            /* 搜索框图标定位 */
            span.formfeedback-xs {
                position: absolute;
                left: 180px;
            }

            body.mobile-body {
                padding-top: 61px;
            }

            div.video-type {
                position: absolute;
                left: 285px;
                top: 3.36667px;
                background-color: orange;
                color: black;
            }

            div.video-time {
                position: absolute;
                left: 251px;
                top: 143px;
                background-color: rgba(0, 0, 0, 0.726);
                color: rgb(255, 255, 255);
            }

            input.mobile-searchform {
                width: 120px !important;
            }


        }

        @media screen and (min-width: 768px) {

            /* 搜索框图标定位 */
            span.form-control-feedback {
                position: absolute;
                left: 112px;

            }

            body.mobile-body {
                padding-top: 51px;
            }

            div.video-type {
                position: absolute;
                left: 174px;
                top: 2.36667px;
                background-color: rgb(255, 123, 0);
                color: black;
            }

            div.video-time {
                position: absolute;
                left: 137px;
                top: 89px;
                background-color: rgba(0, 0, 0, 0.726);
                color: rgb(255, 255, 255);
            }


        }

        @media screen and (min-width: 992px) {
            div.video-type {
                position: absolute;
                left: 170.5px;
                top: 4px;
                background-color: rgb(255, 123, 0);
                color: black;
            }

            div.video-time {
                position: absolute;
                left: 135px;
                top: 87px;
                background-color: rgba(0, 0, 0, 0.726);
                color: rgb(255, 255, 255);
            }


        }


        .navbar-header .navbar-form {
            padding-top: 2px;
        }

        @media screen and (min-width: 1200px) {
            div.navbar-container {
                padding-left: 50px;
                padding-right: 50px;
            }

            div.video-type {
                position: absolute;
                left: 219.5px;
                top: 4px;
                background-color: rgb(255, 123, 0);
                color: black;
            }

            div.video-time {
                position: absolute;
                left: 184.5px;
                top: 109.267px;
                background-color: rgba(0, 0, 0, 1);
                color: rgb(255, 251, 240);
            }

        }

        .video-title {
            padding-top: 15px;
            padding-left: 10px;
            font-size: 20px;
        }

        form.mobileform {
            width: 140px;
        }

        @media screen and (max-width: 1200px) {
            div.mobile-container {
                padding-left: 0px;
                padding-right: 0px;
            }
        }
    </style>
    <link href="../css/app.css?985bcb14808bc6c67072" rel="stylesheet">
    <script type="text/javascript">
        function submitForm() {
            let val = jQuery("#keyword").val()
            if (val != null) {
                jQuery("#search").submit();
            }
        }
    </script>
</head>
<body class="mobile-body">
<!--导航条-->
<nav class="navbar navbar-inverse navbar-fixed-top  navbar-top">
    <div class="container navbar-container">
        <!--导航条头部-->
        <div class="navbar-header " style="float: left;">
            <!--网站图标-->
            <a class="navbar-brand " href="#">
                <img src="../imgs/e67f7fe870.logo.png" alt="icon" style="height:20px">
            </a>
        </div>
        <!--折叠按钮-->
        <div class="navbar-header">
            <!--响应式表单-->
            <form class="navbar-form hidden-lg hidden-md hidden-sm mobileform" style="float: left;" method="post"
                  action="/search" id="search">
                <div class="form-group has-feedback">
                    <div class="input-group input-group-sm btn-searchxs" style="float: left;">
                        <!--输入框组-->
                        <input type="text" class="form-control  mobile-searchform" id="keyword" name="keyword">
                        <span class="input-group-btn">
                                <!--搜索框按钮-->
                                <button type="submit" class="btn btn-primary " onclick="submitForm()">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                    </div>
                    <!--搜索框图标-->
                    <span class="glyphicon glyphicon-camera form-control-feedback  formfeedback-xs" aria-hidden="true">
                        </span>
                </div>
            </form>
            <!--折叠按钮-->
            <button type="button" class="navbar-toggle collapsed  " data-toggle="collapse" data-target="#mynavbar">
                <span class="icon-bar "></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <!--导航条折叠区-->
        <div class="collapse navbar-collapse " id="mynavbar">
            <ul class="nav navbar-nav  ">
                <li><a href="">视频</a></li>
                <li><a href="">分类</a></li>
                <li><a href="/toUpload">上传</a></li>
                <li><a href="/toUserHome">用户中心</a></li>
                <li class="dropdown">
                    <!--下拉菜单按钮-->
                    <a class=" dropdown-toggle" data-toggle="dropdown">
                        more
                        <span class="caret"></span>
                    </a>
                    <!--下拉菜单选项-->
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
                <!--搜索框-->
                <li>
                    <form class="navbar-form  hidden-xs" method="post" action="/search" id="search">
                        <div class="form-group has-feedback">
                            <!--输入框组-->
                            <div class="input-group input-group-sm">
                                <input type="text" class="form-control" id="keyword" name="keyword">
                                <span class="input-group-btn">
                                        <button type="submit" class="btn btn-primary " onclick="submitForm()">
                                            <span class="glyphicon glyphicon-search"></span>
                                        </button>
                                    </span>
                            </div>
                            <!--搜索框图标-->
                            <span class="glyphicon glyphicon-camera form-control-feedback">
                                </span>
                        </div>
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav visible-xs ">
                <#if Session.user?? >
                    <li class="navbar-text"> 欢迎您,[${Session.user.usercode}]!</li>
                    <li><a href="/logout">退出</a></li>
                <#else>
                    <li><a href="/toLogin">登录</a></li>
                    <li><a href="/toRegister">注册</a></li>
                </#if>
            </ul>
            <ul class="nav navbar-nav hidden-xs pull-right">
                <#if Session.user??>
                    <li class="navbar-text"> 欢迎您,[${Session.user.usercode}]!</li>
                    <li><a href="/logout">退出</a></li>
                <#else>
                    <li><a href="/toLogin">登录</a></li>
                    <li><a href="/toRegister">注册</a></li>
                </#if>
            </ul>

        </div>
    </div>
</nav>
<!--幻灯片-->
<div class="container mobile-container">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="../imgs/2ee65e18b4.xiezhen.jpg" class="img-responsive" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="../imgs/70be73f858.xiezhen3.jpg" class="img-responsive" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="../imgs/b70030c09f.xiezhen2.jpg" class="img-responsive" alt="...">
                <div class="carousel-caption">
                    ...
                </div>
            </div>

        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<!--最近添加视频内容区-->
<div class="container container-content ">
    <!-- 内容标题 -->
    <div class="row">
        <div class="col-lg-2 col-md-3 col-sm-4 col-xs-5">
            <div class="video-title "><strong class="text-title">最新添加</strong></div>
        </div>
        <div class="col-lg-2  col-lg-offset-8 col-md-3 col-md-offset-6 col-sm-4 col-sm-offset-4  col-xs-5 col-xs-offset-2">
            <div class="text-right hidden-xs">
                <a href="#" class="btn btn-primary btn-sm  btn-title">
                    <span class="glyphicon glyphicon-plus">More&thinsp;Videos</span>
                </a>
            </div>
            <div class="text-right visible-xs">
                <a href="#" class="btn btn-primary btn-xs btn-title"><span
                            class="glyphicon glyphicon-plus">More&thinsp;Videos</span></a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type ">
                            HD
                        </div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>

    </div>
    <!-- 搜索关键字 -->
    <div class="well">
        <div class="page-header">
            <h1>最近热搜</h1>
        </div>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>
        <a href="" class="btn btn-info btn-searchkey">刘德华</a>

    </div>
</div>
<!-- 广告位 -->
<img src="../imgs/666fd13c7a.rion.jpg" class="img-circle center-block" alt="">
<!--最热视频内容区-->
<div class="container ">
    <!-- 内容标题 -->
    <div class="row">
        <div class="col-lg-2 col-md-3 col-sm-4 col-xs-5">
            <div class="video-title "><strong class="text-title">用户最爱</strong></div>
        </div>
        <div class="col-lg-2  col-lg-offset-8 col-md-3 col-md-offset-6 col-sm-4 col-sm-offset-4  col-xs-5 col-xs-offset-2">
            <div class="text-right hidden-xs">
                <a href="#" class="btn btn-primary btn-sm  btn-title">
                    <span class="glyphicon glyphicon-plus">More&thinsp;Videos</span>
                </a>
            </div>
            <div class="text-right visible-xs">
                <a href="#" class="btn btn-primary btn-xs btn-title"><span
                            class="glyphicon glyphicon-plus">More&thinsp;Videos</span></a>
            </div>
        </div>
    </div>
    <!-- 组件内容区 -->
    <div class="row">
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type ">
                            HD
                        </div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>
        <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
            <!-- well -->
            <div class="well well-sm well1">
                <!-- 视频连接 -->
                <a href="">
                    <!-- 视频缩略图 -->
                    <div class="thumbnail">
                        <img src="../imgs/15ba64f776.images.jpg" class="img-responsive center-block" alt="">
                        <!-- 视频类型 -->
                        <div class="video-type">HD</div>
                        <!-- 视频时长 -->
                        <div class="video-time">02:23:29</div>
                    </div>
                    <!-- 视频标题 -->
                    <span
                            class="videos-titile">rionaaaaaaaaaaaaaaaggggggggggggdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd</span>
                </a>
            </div>

        </div>

    </div>
    <!-- 分页栏 -->
    <div class="row">
        <!-- 手机分页 -->
        <div class="col-xs-8 col-xs-offset-2 visible-xs">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-sm ">
                    <li>
                        <a href="#" aria-label="Previous ">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- 平板分页 -->
        <div class="col-sm-6 col-sm-offset-4 visible-sm">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous ">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- 中等屏幕分页 -->
        <div class="col-md-6 col-md-offset-4 visible-md">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-lg ">
                    <li>
                        <a href="#" aria-label="Previous ">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- 大型屏幕分页 -->
        <div class="col-lg-4 col-lg-offset-4 visible-lg">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-lg ">
                    <li>
                        <a href="#" aria-label="Previous ">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<!-- 广告位 -->
<img src="../imgs/666fd13c7a.rion.jpg" class="img-circle center-block" alt="">
<!-- 底部导航栏 -->
<div class="well">
    <div class="container">
        <div class="row nav-footer">
            <a href="" class="col-lg-2 col-xs-4 text-left">合作洽谈</a>
            <a href="" class="col-lg-2 col-lg-offset-3 col-xs-4 text-left ">捐赠支持</a>
            <a href="" class="col-lg-2 col-lg-offset-3 col-xs-4  text-left">意见反馈</a>
            <a href="" class="col-lg-2 col-xs-4 ">加入我们</a>
            <a href="http://www.baidu.com" class="col-lg-2 col-lg-offset-3 col-xs-4">百度</a>
            <a href="" class="col-lg-2 col-lg-offset-3 col-xs-4">谷歌</a>
        </div>
        <div class="row">
            <!-- 友情连接 -->
            <strong class="col-lg-2  col-xs-4">友情链接</strong>
            <a href="" class="col-lg-2 col-lg-offset-2 col-xs-3">优酷</a>
            <a href="" class="col-lg-2 col-lg-offset-1 col-xs-3">土豆</a>
            <a href="" class="col-lg-2 col-lg-offset-1 col-xs-2">bt</a>
            <a href="" class="col-lg-2  col-xs-3">bt天堂</a>
            <a href="" class="col-lg-2 col-lg-offset-2 col-xs-3">bt天堂</a>
            <a href="" class="col-lg-2 col-lg-offset-2 col-xs-3">bt天堂</a>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/app.js?985bcb14808bc6c67072"></script>
</body>
</html>