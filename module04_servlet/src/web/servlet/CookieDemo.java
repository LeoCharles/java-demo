package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Cookie 是一种将数据保存到客户端的会话技术
 *
 * 原理：基于响应头 set-cookie 和请求头 cookie 实现
 *
 * 特点：
 * 1. 数据在客户端浏览器
 * 2. 浏览器对于单个cookie 的大小有限制(4kb) 以及 对同一个域名下的总cookie数量也有限制(20个)
 *
 * 作用：
 * 1. 存储少量不敏感的数据
 * 2. 在不登录的情况下，完成服务器对客户端的身份识别
 *
 * 使用：
 * new Cookie(String name, String value)：创建 Cookie 对象
 * response.addCookie(Cookie cookie)：发送 Cookie 对象
 * Cookie[]  request.getCookies()：获取 Cookie 对象
 * setMaxAge(int seconds)
 * 1. 正数：将Cookie数据写到硬盘的文件中。持久化存储。并指定cookie存活时间，时间到后，cookie文件自动失效
 * 2. 负数：默认值
 * 3. 零：删除 cookie信息
 *
 */

@WebServlet("/cookie_servlet")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应消息体的数据格式及编码
        response.setContentType("text/html;charset=utf-8");

        // 获取所有 Cookie
        Cookie[] cookies = request.getCookies();

        boolean flag = false;
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 获取 cookie 名称
                String name = cookie.getName();
                // 判断是否有名为 lastTime 的 cookie
                if("lastTime".equals(name)) {
                    flag = true;

                    // 获取 cookie 的值
                    String value = cookie.getValue();

                    // URL 解码
                    value = URLDecoder.decode(value, "utf-8");

                    // 相应数据
                    response.getWriter().write("欢迎回来，您上次访问时间为：" + value);

                    // 获取当前时间
                    String nowTime = getNowTime();

                    // 设置 Cookie 的 value
                    cookie.setValue(nowTime);

                    // 设置 cookie 存活时间
                    cookie.setMaxAge(60 * 60 * 24);

                    // 发送 cookie，更新 cookie 的值
                    response.addCookie(cookie);

                    break;
                }
            }
        }

        // 首次访问
        if(cookies == null || cookies.length == 0 || !flag) {
            // 获取当前时间
            String nowTime = getNowTime();

            // 创建 cookie
            Cookie cookie = new Cookie("lastTime", nowTime);

            // 设置 cookie 存活时间
            cookie.setMaxAge(60 * 60 * 24);

            // 发送 cookie
            response.addCookie(cookie);

            // 相应数据
            response.getWriter().write("您好，欢迎首次访问！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    // 获取当前时间字符串
    String getNowTime() throws UnsupportedEncodingException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);

        // 使用 URL 编码
        str_date = URLEncoder.encode(str_date, "utf-8");

        return str_date;
    }
}
