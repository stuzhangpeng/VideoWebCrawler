<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>注册</title>
    <link href="../css/app.css?985bcb14808bc6c67072" rel="stylesheet">
    <style>
        form.form-horizontal {

        }

    </style>
</head>
<body class="registerbodystyle">
<div class="container">
    <form class="form-horizontal" action="/register" method="post" enctype="multipart/form-data">
        <!-- 用户名 -->
        <div class=" form-group">
            <#-- <label for="inputusername" class="col-sm-2 control-label">用户名</label>-->
            <div class="col-lg-offset-4 col-lg-3">
                <input type="text" class="form-control" id="inputusername" name="username" placeholder="用户名">
                <span>${statusmessage!}</span>
            </div>
        </div>
        <!-- 密码 -->
        <div class="form-group">
            <div class="col-lg-offset-4 col-lg-3">
                <input type="password" class="form-control" id="inputpassword" placeholder="密码" name="password">
            </div>
        </div>
        <!-- 邮箱 -->
        <div class="form-group">
            <div class="col-lg-offset-4 col-lg-3">
                <input type="email" name="email" class="form-control" id="inputEmail" placeholder="邮箱">
            </div>
        </div>
        <!--性别-->
        <div class="form-group">
            <div class="col-lg-offset-4 col-lg-3">
                <label class="radio-inline">
                    <input type="radio" name="gender" id="inlineRadio1" value="男"> 男
                </label>
                <label class="radio-inline">
                    <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
                </label>
            </div>
        </div>
        <!-- 验证码 -->
        <div class="form-group ">
            <div class="col-lg-offset-4 col-lg-2">
                <input type="text" class="form-control" id="inputcode" name="validateCode" placeholder="请输入验证码">
            </div>
            <div class="col-lg-1">
                <img src="/getValidatecode" onclick="changecode()">
            </div>
        </div>
        <!-- 记住我 -->
        <div class="form-group">
            <div class="col-lg-offset-4 col-lg-3">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="rememberMe">下次自动登录
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="hidden" name="token" value="${token!}">
            </div>
        </div>
        <!-- 提交 -->
        <div class="form-group">
            <div class="col-lg-offset-4 col-lg-3">
                <button type="submit" class="btn btn-default">注册</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="../js/app.js?985bcb14808bc6c67072"></script>
</body>
<script>
    function changecode() {
        let img = document.getElementsByTagName("img");
        //重新发送获取验证码，防止浏览器缓存添加时间参数
        img[0].src = "/getValidatecode?time=" + new Date().getTime();
    }
</script>
</html>