<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script>
        window.onload = function () {
            document.getElementById("check-code").onclick = function () {
                this.src = "/module04_servlet/check_code_servlet?time=" + new Date().getTime();
            }
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login_servlet" method="post" class="form">
        <div class="form-header">登录页</div>
        <div class="form-item">
            <label>
                <span class="label-name">用户名：</span>
                <input class="input" type="text" name="username" placeholder="请输入用户名">
            </label>
        </div>
        <div class="form-item">
            <label>
                <span class="label-name">密码：</span>
                <input class="input" type="password" name="password" placeholder="请输入密码">
            </label>
        </div>
        <div class="form-item">
            <label>
                <span class="label-name">验证码：</span>
                <img src="${pageContext.request.contextPath}/check_code_servlet" id="check-code" style="vertical-align: middle;"  alt="check_code">
                <input class="input short" type="text" name="checkCode" placeholder="请输入验证码">
            </label>
        </div>
        <div class="form-footer">
            <button type="submit">登录</button>
        </div>
        <div class="error">
            ${requestScope.check_code_error}
            ${requestScope.login_error}
        </div>
    </form>
</body>
</html>
