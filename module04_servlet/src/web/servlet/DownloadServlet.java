package web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 1. 获取文件名称
 * 2. 使用字节输入流加载文件进内存
 * 3. 设置响应头，以附件的形式下载文件：content-disposition:attachment;filename=xxx
 * 4. 将数据写出到 response 输出流
 *
 *
 */

@WebServlet("/download_servlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数，文件名称
        String filename = request.getParameter("filename");

        // 获取文件真实路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/image/" + filename);

        // 获取原文件类型
        String mimeType = context.getMimeType(filename);

        // 设置响应头
        response.setHeader("content-type", mimeType); // 设置下载文件 MIME 类型
        response.setHeader("content-disposition", "attachment;filename=" + filename); // 打开方式，以附件的方式打开
        // 使用字节输入流加载文件进内存
        FileInputStream fis = new FileInputStream(realPath);

        // 将输入流数据写出输出流（文件对拷）
        ServletOutputStream sos = response.getOutputStream();

        // 创建缓冲区
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        // 循环读取到缓冲区
        while ((len = fis.read(bytes)) != -1) {
            sos.write(bytes, 0, len);
        }

        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
