package web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Listener 监听器
 *
 * 使用方法：
 * 1. 定义一个类，实现 ServletContextListener 接口
 * 2. 复习 方法
 * 3. 配置 使用注解 @WebListener
 *
 */

@WebListener
public class ContextListener implements ServletContextListener {

    // 监听 ServletContext 对象创建
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 服务启动后，自动创建
        System.out.println("ServletContext 创建了");

        // 获取 ServletContext 对象
        ServletContext servletContext = sce.getServletContext();

        // 加载全局资源文件

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 服务关闭后被调用
        System.out.println("ServletContext 被销毁了");
    }
}
