<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <form action="/servlet_demo/request_demo" method="post" class="form">
        <div class="form-header">注册页</div>
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
            <span class="label-name">爱好：</span>
            <label><input type="checkbox" name="hobby" value="game">游戏</label>
            <label><input type="checkbox" name="hobby" value="study">学习</label>
            <label><input type="checkbox" name="hobby" value="read">看书</label>
        </div>
        <div class="form-footer">
            <button type="submit">注册</button>
        </div>
    </form>
</body>
</html>
