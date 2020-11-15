package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 通过 web.xml 配置 servlet
 *
 * <servlet>
 *    <servlet-name>demo1</servlet-name>
 *    <servlet-class>web.servlet.ServletDemo1</servlet-class>
 * </servlet>
 * <servlet-mapping>
 *    servlet-name>demo1</servlet-name>
 *    <url-pattern>/demo1</url-pattern>
 * </servlet-mapping>
 */

public class ServletDemo1 implements Servlet {

    // 初始化方法，只会执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("服务器初始化...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // 提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务器被访问了...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    // 销毁之前执行
    @Override
    public void destroy() {
        System.out.println("服务器关闭了...");
    }
}
