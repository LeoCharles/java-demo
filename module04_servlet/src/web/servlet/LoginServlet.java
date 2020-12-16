package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置 request 请求头
 * 获取参数 Map 集合
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
