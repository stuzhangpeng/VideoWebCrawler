  <!DOCTYPE html>
  <html lang="en">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>登录</title>
  <link href="../css/app.css?985bcb14808bc6c67072" rel="stylesheet">
    <style>
      .container{
        margin-top: 120px;
        background-color: whitesmoke;
      }
      .form-horizontal{
        margin-top: 10px;
      }
    </style>
    <script>
      function changecode(){
        let img=document.getElementsByTagName("img");
        //重新发送获取验证码，防止浏览器缓存添加时间参数
        img[0].src="/getLoginValidatecode?time="+new Date().getTime();
      }
    </script>
  </head>
  <body class="bodystyle">
    <div class="container">
        <div class="row">
          <div class="col-lg-offset-4 col-lg-1" ><a href="/">去首页</a> </div>
          <div class="col-lg-offset-1 col-lg-2 right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/toRegister">没有账号?去注册</a></div>
        </div>
        <form class="form-horizontal" action="/login" method="post">
          <!-- 用户名 -->
          <div class="form-group">
            <div class="col-lg-offset-4 col-lg-4">
              <input value="${namekey!''}" type="text" class="form-control" name="username" id="inputusername" placeholder="用户名">
            </div>
            <span>${statusmessage!}</span>
          </div>
          <!-- 密码 -->
          <div class="form-group">
            <div class="col-lg-offset-4 col-lg-4">
              <input value="${passwordkey!''}"type="password"  name="password" class="form-control" id="inputpassword" placeholder="密码">
            </div>
          </div>
          <!-- 验证码 -->
          <div class="form-group">
            <div class="col-lg-offset-4 col-lg-3">
              <input type="text" class="form-control" id="inputcode" name="validateCode" placeholder="验证码">
            </div>
            <div class="col-lg-1">
              <img src="/getLoginValidatecode" onclick="changecode()">
            </div>
          </div>
          <!-- 记住我 -->
          <div class="form-group">
            <div class="col-lg-offset-4 col-lg-4">
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
          <!-- 登录 -->
          <div class="form-group">
            <div class="col-lg-offset-4 col-lg-4">
              <button type="submit" class="btn btn-primary">登录</button>
            </div>
          </div>
        </form>
    </div>
  <script type="text/javascript" src="../js/app.js?985bcb14808bc6c67072"></script></body>
  </html>                                                               