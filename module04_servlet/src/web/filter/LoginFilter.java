package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        // 获取资源请求路径
        String uri = request.getRequestURI();

        // 排除登录相关的资源以及 css、js、图片、验证码等资源
        if (uri.contains("/index.jsp")
                || uri.contains("/login.jsp")
                || uri.contains("/css/")
                || uri.contains("/js/")
                || uri.contains("/image/")
                || uri.contains("login_servlet")
                || uri.contains("check_code_servlet")) {
            chain.doFilter(req, resp);
        } else {
            // 判断用户是否登录
            Object user = request.getSession().getAttribute("user");

            // 如果已登录，放行
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                // 没有登录，跳转到登录信息
                request.setAttribute("login_msg", "您尚未登录，请先登录");

                // 跳转到登录页
                request.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        }

        // 判断资源请求路径



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
