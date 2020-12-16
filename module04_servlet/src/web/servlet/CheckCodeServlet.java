package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 生成验证码
 */

@WebServlet("/check_code_servlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 创建一个图片对象
        int width = 100;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取画笔对象
        Graphics g = image.getGraphics();
        // 设置画笔颜色
        g.setColor(Color.ORANGE);
        // 填充背景色
        g.fillRect(0, 0, width, height);
        // 设置画笔颜色
        g.setColor(Color.GRAY);
        // 画边框
        g.drawRect(0, 0, width - 1, height -1);

        // 随机生成 4 个字符，写入图片
        Random random = new Random();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            // 随机获取默认字符串下标
            int idx = random.nextInt(str.length());
            // 获取字符
            char ch = str.charAt(idx);
            // 生成字符
            sb.append(ch);
            //将字符写入验证码图片
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman",Font.BOLD,24));
            g.drawString(ch + "", width / 4 * i, height * 2 / 3);
        }

        // 将验证码存入 Session
        String checkCode = sb.toString();
        request.getSession().setAttribute("check_code_session", checkCode);

        // 随机生成干扰线
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);

            g.setColor(Color.GREEN);
            g.drawLine(x1, y1, x2, y2);
        }

        // 将图片输出到页面
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
