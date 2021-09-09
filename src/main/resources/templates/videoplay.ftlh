<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>视频详情</title>
    <style>
        div.related-content{
            display: none;
        }
        div.videoplay{
            position: relative;
        }
        div.video-titleshow{
            position: absolute;
            top: 0;
            left: 50%;
            z-index: 10;
            color: black;
            font-size: 20px;
        }
        div.videocontainer{
            margin-top: 70px;
        }
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
</head>
<body>
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
            <form class="navbar-form hidden-lg hidden-md hidden-sm mobileform" style="float: left;">
                <div class="form-group has-feedback">
                    <div class="input-group input-group-sm btn-searchxs" style="float: left;">
                        <!--输入框组-->
                        <input type="text" class="form-control  mobile-searchform" id="search" placeholder="aaa">
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
                <li><a href="/">视频</a></li>
                <li><a href="">分类</a></li>
                <li><a href="/toUpload">上传</a></li>
                <li><a href="/toUserHome">用户中心</a></li>
                <li class="dropdown">
                    <!--下拉菜单按钮-->
                    <a class=" dropdown-toggle" data-toggle="dropdown">
                        分类
                        <span class="caret"></span>
                    </a>
                    <!--下拉菜单选项-->
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li><a href="#">武侠</a></li>
                        <li><a href="#">动漫</a></li>
                        <li><a href="#">动作</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">悬疑</a></li>
                        <li><a href="#">都市</a></li>
                        <li><a href="#">恐怖</a></li>
                    </ul>
                </li>
                <!--搜索框-->
                <li>
                    <form class="navbar-form  hidden-xs">
                        <div class="form-group has-feedback">
                            <!--输入框组-->
                            <div class="input-group input-group-sm">
                                <input type="text" class="form-control" id="search1" placeholder="snis">
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
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav visible-xs ">
                <@shiro.guest>
                    <li><a href="/toLogin">登录</a></li>
                    <li><a href="/toRegister">注册</a></li>
                </@shiro.guest>
                <@shiro.user>
                    <li class="navbar-text"> 欢迎[<@shiro.principal property="usercode"/>]登录</li>
                    <li><a href="/logout">退出</a></li>
                </@shiro.user>
            </ul>
            <ul class="nav navbar-nav hidden-xs pull-right">
                <@shiro.guest>
                    <li><a href="/toLogin">登录</a></li>
                    <li><a href="/toRegister">注册</a></li>
                </@shiro.guest>
                <@shiro.user>
                    <li class="navbar-text"> 欢迎您[<@shiro.principal property="usercode"/>]</li>
                    <li><a href="/logout">退出</a></li>
                </@shiro.user>
            </ul>

        </div>
    </div>
</nav>
<!-- 视频播放 -->
<script type="text/javascript" src="../js/app.js?985bcb14808bc6c67072"></script>
<div class="container videocontainer">
    <#if video??>
    <#--视频详细信息-->
            <div class="media row">
                <div class="col-lg-5">
                    <div class="media-left  ">
                        <img class="media-object img-responsive " src="${video.picturefile}"  alt="${video.name}">
                    </div>
                </div>
                <div class="col-lg-6 col-lg-offset-1">
                    <div class="media-body " style="float: left">
                        <h3 class="media-heading">视频详情</h3>
                        <h4 >名称:${video.name}</h4>
                        <h4 >标题:${video.title}</h4>
                        <h4 >时长:${(video.time)}</h4>
                        <h4 >质量:${video.quality}</h4>
                        <h4 >上传时间:${video.uploadtime?date}</h4>
                        <h4 >观看量:${video.views!'0'}</h4>
                        <h4 >演员:${video.role}</h4>
                        <h4 >分类:${video.category}</h4>
                    </div>
                </div>
            </div>
        <div class="videoplay">
            <#--视频标题-->
            <div class="video-titleshow">${video.title}</div>
            <#--视频播放器-->
            <div id="video" style="width: 1080px;height: 606px">
            </div>
        </div>

        <script type="text/javascript" src="../ckplayer/ckplayer.js" charset="UTF-8"></script>
        <script type="text/javascript">
            let videoObject = {
                container: '#video',//“#”代表容器的ID，“.”或“”代表容器的class
                variable: 'player',//该属性必需设置，值等于下面的new chplayer()的对象
                flashplayer: false,//如果强制使用flashplayer则设置成true
                autoplay:true,//自动播放
                loop:true,//循环播放
                mobileCkControls:true,
                mobileAutoFull:false,
                poster:"${video.picturefile}",//视频播放器封面
                video: '${video.path}'//视频地址
            };
            let player = new ckplayer(videoObject);
        </script>
    <#else>
        <div class="center-block">视频文件没找到</div>
    </#if>
</div>
<#--tags用于快速搜索-->
<#--上传者信息-->
<div class="container container-content">
    <ul class="nav nav-pills">
        <li role="presentation" ><a href="javaScript:void(0)">相关视频</a></li>
        <li role="presentation"><a href="javaScript:void(0)">评论</a></li>
    </ul>
    <#--从solr中搜索相关内容-->
    <#if relatedVideos??>
    <#--内容区-->
        <div class="row related-content">
            <#list relatedVideos as item>
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-12">
                    <!-- well -->
                    <div class="well well-sm well1">
                        <!-- 视频连接 -->
                        <a href="playVideo?id=${item.vid}">
                            <!-- 视频缩略图 -->
                            <div class="thumbnail">
                                <img src="${item.picturefile}" class="img-responsive center-block" onload="drawImage(this)" />
                                <!-- 视频类型 -->
                                <div class="video-type ">
                                    ${item.quality}
                                </div>
                                <!-- 视频时长 -->
                                <div class="video-time">${(item.time)!"00:00"!"00:00"}</div>
                            </div>
                            <!-- 视频标题 -->
                            <span class="videos-titile">${item.title}</span>
                            <#--上传日期-->
                            <span>${(item.uploadtime)?date}</span>
                            <#--删除按钮-->
                            <a href="/removeFile?id=${item.vid}" class="btn btn-danger">删除</a>
                            <#--下载-->
                            <a href="/downloadFile?id=${item.vid}" class="btn btn-primary">下载</a>
                        </a>
                    </div>
                </div>
            </#list>
        </div>
    <#--分页-->
    <#--  <nav aria-label="Page navigation" style="text-align: center">
          <ul class="pagination pagination-lg">
              <#if fileList.hasPreviousPage>
                  <li>
                      <a href="/getPageVideo?pageNumber=${fileList.prePage}" aria-label="Previous ">
                          <span aria-hidden="true">&laquo;</span>
                      </a>
                  </li>
              </#if>
              <#if fileList.isFirstPage>
              &lt;#&ndash;当前页码&ndash;&gt;
                  <li>
                                  <span>
                                      <span aria-hidden="true">${fileList.pageNum}</span>
                                 </span>
                  </li>
              <#elseif fileList.isLastPage>
              &lt;#&ndash;首页&ndash;&gt;
                  <li><a href="/getPageVideo">1</a></li>
              &lt;#&ndash;当前页&ndash;&gt;
                  <li>
                                   <span>
                                      <span aria-hidden="true">${fileList.pageNum}</span>
                                 </span>
                  </li>
              <#else>
              &lt;#&ndash;首页&ndash;&gt;
                  <li><a href="/getPageVideo">1</a></li>
              &lt;#&ndash;当前页&ndash;&gt;
                  <li>
                                  <span>
                                      <span aria-hidden="true">${fileList.pageNum}</span>
                                 </span>
                  </li>
              </#if>
              &lt;#&ndash;下一页&ndash;&gt;
              <#if fileList.hasNextPage>
                  <li><a href="/getPageVideo?pageNumber=${fileList.pages}">${fileList.pages}</a></li>
                  <li>
                      <a href="/getPageVideo?pageNumber=${fileList.nextPage}" aria-label="Next">
                          <span aria-hidden="true">&raquo;</span>
                      </a>
                  </li>
              </#if>
          </ul>
      </nav>-->
    <#else>
    <#--内容区-->
        <div class="well well-sm  related-content">
            没有相关视频
        </div>
    </#if>
    <#--视频评论-->
    <div class="row related-content">
        <div class="well well-sm">
            没有评论
        </div>
    </div>
</div>

<!-- 视频评价 -->
<#--广告位-->
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
<script src="../js/app.js">

</script>
<script>
 jQuery("ul.nav-pills li").click(function () {
     jQuery(this).addClass("active");
     jQuery("ul.nav-pills li").not(jQuery(this)).removeClass("active");
     let idx = jQuery(this).index("ul.nav-pills li");
     jQuery(".related-content").eq(idx).show(100);
     jQuery(".related-content").not( jQuery(".related-content").eq(idx)).hide(100);
 });
 jQuery("ul.nav-pills li").eq("0").addClass("active");
 jQuery(".related-content").eq("0").show();
</script>
</body>
</html>