<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>搜索详情</title>
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
        function search() {
            jQuery("#search").submit();
        }
        function changeSort(sort) {
            jQuery("input[name='sort']").val(jQuery(sort).text());
            //提交表单
            search();
        }
        function changePage(page) {
            jQuery("input[name='pageNumber']").val(jQuery(page).text());
            //提交表单
            search();
        }
    </script>
</head>
<body class="mobile-body">
    <#--导航条-->
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
                <form class="navbar-form hidden-lg hidden-md hidden-sm mobileform" style="float: left;" action="/search" method="post" id="search1">
                    <div class="form-group has-feedback">
                        <div class="input-group input-group-sm btn-searchxs" style="float: left;">
                            <!--输入框组-->
                            <#--搜索关键字回显-->
                            <input type="text" name="keyword" class="form-control  mobile-searchform" id="search" value="${(searchResult.keyword)!''}" >
                            <span class="input-group-btn">
                                <!--搜索框按钮-->
                                <button type="submit" class="btn btn-primary ">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </span>
                        </div>
                        <!--搜索框图标-->
                        <span class="glyphicon glyphicon-camera form-control-feedback  formfeedback-xs" aria-hidden="true">
                        </span>
                    </div>
                    <#--隐藏框排序默认按添加时间降序排列-->
                    <#--需要回显-->
                    <input type="hidden" name="sort" value="${(searchResult.sort)!''}">
                    <#--隐藏框分页，默认显示第一页-->
                    <#--需要回显-->
                    <input type="hidden" name="pageNumber" value="${(searchResult.pageNumber)!'1'}">
                </form>
                <!--折叠按钮-->
                <button type="button" class="navbar-toggle collapsed " data-toggle="collapse" data-target="#mynavbar">
                    <span class="icon-bar "></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
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
                    <#--搜索关键字回显-->
                    <!--搜索框-->
                    <li>
                        <form class="navbar-form  hidden-xs" method="post" action="/search" id="search">
                            <div class="form-group has-feedback">
                                <!--输入框组-->
                                <div class="input-group input-group-sm">
                                    <#--关键字回显-->
                                    <input type="text" class="form-control" id="search1" value="${(searchResult.keyword)!''}">
                                    <span class="input-group-btn">
                                        <button type="submit" class="btn btn-primary ">
                                            <span class="glyphicon glyphicon-search"></span>
                                        </button>
                                    </span>
                                </div>
                                <!--搜索框图标-->
                                <span class="glyphicon glyphicon-camera form-control-feedback">
                                </span>
                            </div>
                            <#--隐藏框排序默认按添加时间降序排列-->
                            <input type="hidden" name="sort" value="${(searchResult.sort)!''}">
                            <#--隐藏框分页，默认显示第一页-->
                            <input type="hidden" name="pageNumber" value="${(searchResult.pageNumber)!'1'}">
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-nav visible-xs ">
                    <@shiro.guest>
                        <li><a href="/toLogin">登录</a></li>
                        <li><a href="/toRegister">注册</a></li>
                    </@shiro.guest>
                    <@shiro.user>
                        <li class="navbar-text" > 欢迎[<@shiro.principal property="usercode"/>]登录</li>
                        <li> <a href="/logout">退出</a></li>
                    </@shiro.user>
                </ul>
                <ul class="nav navbar-nav hidden-xs pull-right">
                    <@shiro.guest>
                        <li><a href="/toLogin">登录</a></li>
                        <li><a href="/toRegister">注册</a></li>
                    </@shiro.guest>
                    <@shiro.user>
                        <li class="navbar-text"> 欢迎您[<@shiro.principal property="usercode"/>]</li>
                        <li> <a href="/logout">退出</a></li>
                    </@shiro.user>
                </ul>
            </div>
            </div>
        </div>
    </nav>
    <!-- 搜索结果过滤排序 -->
    <div class="container container-content ">
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="#">观看量</a></li>
            <li role="presentation"><a href="javascript:void(0);" onclick="changeSort(this)">添加时间</a></li>
            <li role="presentation"><a href="javascript:void(0);" onclick="changeSort(this)" >视频长度</a></li>
            <li role="presentation"><a href="javascript:void(0);" onclick="changeSort(this)">收藏量</a></li>
            <li role="presentation"><a href="javascript:void(0);" onclick="changeSort(this)">评论量</a></li>
            <li role="presentation"><a href="javascript:void(0);" onclick="changeSort(this)">喜爱度</a></li>
        </ul>
        <#if searchResult??>
        <#--内容区-->
            <div class="row">
                <#list searchResult.video as item>
                    <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
                        <!-- well -->
                        <div class="well well-sm well1">
                            <!-- 视频连接 -->
                            <a href="playVideo?id=${item.vid}">
                                <!-- 视频缩略图 -->
                                <div class="thumbnail">
                                    <img src="${(item.picturefile)!''}" class="img-responsive center-block" onload="drawImage(this)" />
                                    <!-- 视频类型 -->
                                    <div class="video-type ">
                                        ${item.quality}
                                    </div>
                                    <!-- 视频时长 -->
                                    <div class="video-time">${(item.time)!"00:00"}</div>
                                </div>
                                <!-- 视频标题 -->
                                <span class="videos-titile">${item.title}</span>
                                <#--上传日期-->
                                <span>${(item.uploadtime)?date}</span>
                                <span>${(item.views)!''}</span>
                            </a>
                        </div>
                    </div>
                </#list>
            </div>
        <#--分页-->
            <nav aria-label="Page navigation" style="text-align: center">
                <ul class="pagination pagination-lg">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="javascript:void(0)" onclick="changePage(1)">1</a></li>
                    <li><a href="javascript:void(0)" class="disabled" >${searchResult.pageNumber}</a></li>
                    <li><a href="javascript:void(0)" onclick="changePage(${(searchResult.pageTotal)})" >${(searchResult.pageTotal)}</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        <#else>
        <#--内容区-->
            <div class="well well-sm">
                <span>抱歉,没有找到相关结果！</span>
            </div>
        </#if>
        <div class="panel panel-primary">
            <div class="panel-heading text-center">搜索分类</div>
            <div class="list-group">
                <a href="#" class="list-group-item list-group-item-info" >喜剧 <span class="badge">1</span></a>
                <a href="#" class="list-group-item list-group-item-info" >爱情<span class="badge">2</span></a>
                <a href="#" class="list-group-item list-group-item-info" >动作<span class="badge">3</span></a>
                <a href="#" class="list-group-item list-group-item-info">枪战<span class="badge">4</span></a>
                <a href="#" class="list-group-item list-group-item-info ">犯罪<span class="badge">5</span></a>
                <a href="#" class="list-group-item list-group-item-info">惊悚<span class="badge">6</span></a>
                <a href="#" class="list-group-item list-group-item-info">恐怖<span class="badge">7</span></a>
                <a href="#" class="list-group-item list-group-item-info">悬疑<span class="badge">8</span></a>
                <a href="#" class="list-group-item list-group-item-info">动画<span class="badge">9</span></a>
                <a href="#" class="list-group-item list-group-item-info">家庭<span class="badge">10</span></a>
                <a href="#" class="list-group-item list-group-item-info">剧情片<span class="badge">11</span></a>
                <a href="#" class="list-group-item list-group-item-info ">奇幻<span class="badge">12</span></a>
                <a href="#" class="list-group-item list-group-item-info">战争<span class="badge">13</span></a>
                <a href="#" class="list-group-item list-group-item-info">青春<span class="badge">14</span></a>
                <a href="#" class="list-group-item list-group-item-info ">伦理片<span class="badge">15</span></a>
                <a href="#" class="list-group-item list-group-item-info">传记片<span class="badge">16</span></a>
            </div>
        </div>
    </div>
    <#--底部导航条-->
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