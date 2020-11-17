package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * request 对象继承体系：
 * ServletRequest(接口) -->  HttpServletRequest(接口) --> RequestFacade(实现类，Tomcat实现)
 *
 * 获取请求行数据：
 * etMethod()：请求方法
 * getContextPath()：获取虚拟目录
 * getServletPath()：获取 Servlet 路径
 * getQueryString()：获取 GET 请求参数
 * getRequestURI()：获取请求的 URI
 * getRequestURL()：获取请求的 URL
 * getProtocol()：获取协议和版本
 * getRemoteAddr()：获取客户机 IP
 *
 * 获取请求头数据：
 * getHeaderNames()：获取所有的请求头名称，返回一个枚举
 * getHeader()：通过请求头的名称，获取值
 *
 * 获取 POST 请求体数据：
 * 先获取流对象，再从流对象中获取数据
 * getReader(): 获取字符输入流，只能操作字符数据
 * getInputStream(): 获取字节输入流，可以操作所有类型数据，用于文件上传等
 *
 * 获取请求参数的通用方法(GET 和 POST 都可以)
 * 在获取参数前设置 request 编码： request.setCharacterEncoding("utf-8");
 * getParameter(): 根据参数名获取参数值
 * getParameterValues(): 根据参数名获取参数值数组
 * getParameterNames(): 根据所有的参数名，返回一个枚举
 * getParameterMap(): 获取所有参数的 Map 集合
 *
 * 请求转发
 * 一种在服务器内部资源跳转方法
 *
 * 共享数据
 *
 * 获取 ServletContext
 *
 *
 *
 */

@WebServlet("/request_demo")
public class RequestDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 统一在 doGet 中处理，不需要单独在 doPost 获取请求体数据
        this.doGet(request, response);

        /*
        // 获取字符流
        BufferedReader br = request.getReader();
        // 读取字符流数据
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式:" + method);

        // 获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println("虚拟目录:" + contextPath);

        // 获取 Servlet 路径
        String servletPath = request.getServletPath();
        System.out.println("Servlet 路径:" + servletPath);

        // 获取 GET 请求参数
        String queryString = request.getQueryString();
        System.out.println("请求参数:" + queryString);

        // 获取请求的 URI
        String requestURI = request.getRequestURI();
        System.out.println("URI:" + requestURI);

        // 获取请求的 URL
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("URL:" + requestURL);

        // 获取协议和版本
        String protocol = request.getProtocol();
        System.out.println("协议和版本:" + protocol);

        // 获取客户机 IP
        String remoteAddr = request.getRemoteAddr();
        System.out.println("客户机 IP:" + remoteAddr);

        // 设置流的编码，防止中文乱码
        request.setCharacterEncoding("utf-8");

        // 获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        // 遍历所有的请求头名称
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();

            // 根据请求头名称获取值
            String header = request.getHeader(name);
            System.out.println(name + ":" + header);
        }

        // 根据请求参数名获取值
        String password = request.getParameter("password");
        System.out.println("password:" + password);

        // 根据参数名获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        // 获取所有请求参数
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + ":" + value);
        }

        // 获取所有参数的 Map 集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.println(key + ":" + value);
            }
        }
    }
}
