package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 设置 request 请求头
 * 获取参数
 * 获取验证码
 * 将用户信息封装到 User 对象
 * 从 Session 中获取程序生成的验证码
 * 判断程序生成的验证码和用户输入的验证码是否一致
 * 如果不一致，提示验证码错误，跳转到登录页(转发)
 * 如何一致，再判断用户名和密码是否正确
 * 如果正确，登录成功，存储用户信息到 Session，跳转到欢迎页
 * 如何不正确，给错误提示跳转到登录页
 *
 */

@WebServlet("/login_servlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("utf-8");

        // 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        // 获取生成的验证码
        HttpSession session = request.getSession();
        String check_code_session = (String) session.getAttribute("check_code_session");

        // 获取验证码后立马删除，只能用一次
        session.removeAttribute("check_code_session");

        // 判断验证码是否正确，忽略大小写
        if (check_code_session != null && check_code_session.equalsIgnoreCase(checkCode)) {
            // 判断用户名密码是否正确
            if ("leo".equals(username) && "123456".equals(password)) {
                // 登录成功，存储用户信息
                session.setAttribute("user", username);
                // 重定向到欢迎页
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                // 存储信息
                request.setAttribute("login_error", "用户名或密码错误");
                // 转发到登录页
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            // 存储信息
            request.setAttribute("check_code_error", "验证码错误");
            // 转发到登录页
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
