
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>servlet</title>
  </head>
  <body>
    <h1>hello servlet demo</h1>
    <ul>
      <li><a href="/servlet_demo/demo1">通过 web.xml 配置 servlet</a></li>
      <li><a href="/servlet_demo/demo2">通过注解配置 servlet</a></li>
      <li><a href="/servlet_demo/register.html">注册页</a></li>
      <li><a href="/servlet_demo/request_demo?name=leo&age=20">请求对象</a></li>
      <li><a href="/servlet_demo/response_demo">响应对象</a></li>
      <li><a href="/servlet_demo/servlet_context">ServletContext对象</a></li>
      <li><a href="/servlet_demo/download_servlet?filename=java.jpg">图片下载</a></li>
      <li><a href="/servlet_demo/cookie_servlet">Cookie</a></li>
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
