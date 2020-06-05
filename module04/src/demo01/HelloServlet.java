package demo01;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet生命周期：
 * 1. 加载 Servlet，当 Tomcat 第一次访问 Servlet 的时候，Tomcat 会负责创建 Servlet 的实例
 * 2. 初始化。当 Servlet 被实例化后，Tomcat 会调用 init()方法初始化这个对象
 * 3. 处理服务。当浏览器访问 Servlet 的时候，Servlet 会调用 service()方法处理请求
 * 4. 销毁。当 Tomcat 关闭时或者检测到 Servlet 要从 Tomcat 删除的时候会自动调用 destroy()方法，让该实例释放掉所占的资源
 * 5. 卸载。当 Servlet 调用完 destroy()方法后，等待垃圾回收
 *
 */

public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(servletRequest);
        System.out.println(servletResponse);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
