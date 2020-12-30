package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * Filter 过滤器
 *
 * 概念：一般用于完成通用的操作，如：登录验证、统一编码处理、敏感字符过滤等
 *
 * 使用步骤：
 * 1. 定义一个类，实现 Filter 接口
 * 2. 复写方法 doFilter
 * 3. 配置拦截路径
 * 4. 设置过滤条件后，调用 filterChain.doFilter() 方法放行
 *
 * 配置拦截路径方式
 * 1. 使用 web.xml 配置
 *     <filter>
 *         <filter-name>demo1</filter-name>
 *         <filter-class>web.filter.FilterDemo</filter-class>
 *     </filter>
 *     <filter-mapping>
 *         <filter-name>demo1</filter-name>
 *         <url-pattern>/*</url-pattern>
 *     </filter-mapping>
 * 2. 使用注解配置： @WebFilter("/*")
 *
 * 配置拦截路径
 * 1. 具体资源路径：/index.jsp
 * 2. 拦截目录：/user/*  访问 /user 下的所有资源时过滤器都会被执行
 * 3. 后缀名拦截：*.jsp 访问所有的 jsp 文件都会被拦截
 *
 */

@WebFilter("/*") // 访问所有资源都会执行该过滤器
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 服务器启动后，会创建 Filter 对象，执行 init() 方法，用于加载资源
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 先对请求对象 ServletRequest 进行增强

        System.out.println("filter 被执行了...");

        // 放行，去请求资源
        filterChain.doFilter(servletRequest, servletResponse);

        // 再对响应对象 ServletResponse 进行增强
    }

    @Override
    public void destroy() {
        // 服务器关闭后，Filter 对象被销毁时执行 destroy() 方法，用于释放资源
    }
}
