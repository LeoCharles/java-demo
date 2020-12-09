package web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext 对象
 * 代表整个 web 应用，可以和程序的容器(服务器)来通信
 *
 * 功能：
 * 1. 获取 MIME 类型，格式：大类型/小类型   如：text/html image/jpeg
 * 2. 是一个域对象，可以用来共享数据
 * 3. 获取文件的真实路径
 *
 * 获取 ServletContext 对象：
 * request.getServletContext(): 获取 ServletContext 对象
 * this.getServletContext(): 直接从 HttpServlet 获取 ServletContext 对象
 *
 * 方法：
 * getMimeType()：获取 MIME 类型
 * setAttribute()：存储数据
 * getAttribute()：通过键获取值
 * removeAttribute()：通过键移除键值对
 * getRealPath(): 取文件的真实(服务器)路径
 *
 */

@WebServlet("/servlet_context")
public class ServletContextDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取 ServletContext，可以和服务器通信
        ServletContext servletContext = this.getServletContext();

        // 获取 MIME 类型
        String mimeType = servletContext.getMimeType("a.jpg");
        System.out.println(mimeType);

        // 设置数据
        servletContext.setAttribute("msg", "hello");

        // 获取文件真实路径
        String p1 = servletContext.getRealPath("/index.jsp"); // 访问 web 目录下资源
        System.out.println(p1);

        String p2 = servletContext.getRealPath("/WEB-INF/web.xml"); // 访问 WEB-INF目录下的资源
        System.out.println(p2);

        String p3 = servletContext.getRealPath("/WEB-INF/classes/readme.txt"); // src 目录下的资源会被放到/WEB-INF/classes 目录下
        System.out.println(p3);
    }
}
