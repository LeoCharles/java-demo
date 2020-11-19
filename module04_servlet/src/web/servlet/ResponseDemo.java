package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Response对象
 *
 * 设置响应行
 * setStatus(): 设置状态码
 *
 * 设置响应头
 * setHeader():设置响应头
 *
 * 设置响应体
 * 先获取输出流，再将数据输出到客户端
 * getWriter(): 字符输出流，获取的流，默认编码是ISO-8859-1
 * getOutputStream()：字节输出流
 * 在获取流之前设置编码
 * response.setContentType("text/html;charset=utf-8");
 *
 * 重定向
 * 设置状态码为302，设置响应头 location
 * response.setStatus(302);
 * response.setHeader("location", "/servlet_demo/request_demo");
 * 简单的重定向方法:
 * response.sendRedirect("/servlet_demo/request_demo");
 * 特点:
 * 地址栏发生变化
 * 可以访问其他站点(服务器)的资源
 * 重定向是两次请求。不能使用request对象来共享数据
 *
 * 转发：
 * 地址栏路径不变
 * 只能访问当前服务器下的资源
 * 转发是一次请求，可以使用request对象来共享数据
 *
 */

@WebServlet("/response_demo")
public class ResponseDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        // 设置状态码
        response.setStatus(302);
        // 设置响应头
        response.setHeader("location", "/servlet_demo/request_demo");

        // 简单的重定向方法
        response.sendRedirect("/servlet_demo/request_demo");
        */


        // 设置响应体，服务器输出字符数据到浏览器
        // 设置流的默认编码
        // response.setCharacterEncoding("utf-8");

        // 告诉浏览器响应体数据的编码
        // response.setHeader("content-type", "text/html;charset=utf-8");
        // 设置编码简单形式
        response.setContentType("text/html;charset=utf-8");

        // 获取字符输出流
        PrintWriter pw = response.getWriter();
        pw.write("<h1>你好 response</h1>");

        // 获取字节输出流
        ServletOutputStream sos = response.getOutputStream();
        sos.write("字节数据".getBytes("utf-8"));
    }
}
