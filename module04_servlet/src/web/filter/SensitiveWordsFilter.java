package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 过滤敏感词
 */

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    //敏感词汇集合
    private List<String> list = new ArrayList<>();

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 创建代理对象
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 增强 getParameter 方法
                if (method.getName().equals("getParameter")) {
                    // 获取返回值
                    String value = (String) method.invoke(req, args);

                    // 增强返回值
                    if (value != null) {
                        for (String str : list) {
                            // 替换敏感词
                            if (value.contains(str)) {
                                value = value.replace(str, "***");
                            }
                        }
                    }

                    return value;
                }

                return method.invoke(req, args);
            }
        });

        // 放行
        chain.doFilter(proxy_req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        try {
            // 获取敏感词文件路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/SensitiveWords.txt");

            // 读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));

            // 将文件的每一行数据添加到 list 集合中
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            // 释放资源
            br.close();

            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }

}
