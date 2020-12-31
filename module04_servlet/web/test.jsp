<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<form action="${pageContext.request.contextPath}/test_servlet" class="form">
    <h3 class="form-header">测试敏感词</h3>
    <div class="form-item">
        <label>姓名：<input name="name"></label>
    </div>
    <div class="form-item">
        <label>留言：<textarea name="msg"></textarea></label>
    </div>
    <div class="form-footer">
        <button type="submit">提交</button>
    </div>
</form>
</body>
</html>
