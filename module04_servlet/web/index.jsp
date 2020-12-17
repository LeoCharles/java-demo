
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>servlet</title>
  </head>
  <body>
    <h1>hello <%= request.getSession().getAttribute("user") == null ? "servlet" : request.getSession().getAttribute("user") %></h1>
    <ul>
      <li><a href="${pageContext.request.contextPath}/demo1">通过 web.xml 配置 servlet</a></li>
      <li><a href="${pageContext.request.contextPath}/demo2">通过注解配置 servlet</a></li>
      <li><a href="${pageContext.request.contextPath}/register.jsp">注册页</a></li>
      <li><a href="${pageContext.request.contextPath}/login.jsp">登录页</a></li>
      <li><a href="${pageContext.request.contextPath}/check_code_servlet">验证码</a></li>
      <li><a href="${pageContext.request.contextPath}/request_demo?name=leo&age=20">请求对象</a></li>
      <li><a href="${pageContext.request.contextPath}/response_demo">响应对象</a></li>
      <li><a href="${pageContext.request.contextPath}/servlet_context">ServletContext对象</a></li>
      <li><a href="${pageContext.request.contextPath}/download_servlet?filename=java.jpg">图片下载</a></li>
      <li><a href="${pageContext.request.contextPath}/cookie_servlet">Cookie</a></li>
      <li><a href="${pageContext.request.contextPath}/session_servlet">Session</a></li>
    </ul>

    <%
      // 在 service() 方法中的代码
      String contextPath = request.getContextPath();
      System.out.println(contextPath);

      // 直接输出内容到页面
      out.print(contextPath);

      // 内置对象 request response out
    %>

    <%!
      // 在 java 类的成员位置的代码
      String page = "jsp";

    %>

    <%="<p>在 JSP 中直接输入到页面中的内容</p>"%>
  </body>
</html>
