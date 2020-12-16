<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <form action="/servlet_demo/login_servlet" method="post" class="form">
        <div class="form-header">登录页</div>
        <div class="form-item">
            <label>
                <span class="label-name">用户名：</span>
                <input type="text" name="name" placeholder="请输入用户名">
            </label>
        </div>
        <div class="form-item">
            <label>
                <span class="label-name">密码：</span>
                <input type="password" name="password" placeholder="请输入密码">
            </label>
        </div>
        <div class="form-item">
            <label>
                <span class="label-name">验证码：</span>
                <img src="/servlet_demo/check_code_servlet"  alt="check_code">
                <input type="text" name="check_code" style="width: 90px;" placeholder="请输入验证码">
            </label>
        </div>
        <div class="form-footer">
            <button type="submit">登录</button>
        </div>
    </form>
</body>
</html>
