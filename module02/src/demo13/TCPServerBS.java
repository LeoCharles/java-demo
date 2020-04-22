package demo13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BS 版 TCP 服务器
 *
 * 使用 IT 浏览器访问 http://127.0.0.1:8888/module02/src/demo13/web/index.html
 *
 * 浏览器解析服务器回写的 html 时，如果有图片、js等资源时，则浏览器会单独开一个线程，读取服务器资源
 * 需要让服务器一直处于监听状态，浏览器请求一次，服务器就回写一次
 *
 *
 */

public class TCPServerBS {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动，等待连接...");

        // 创建服务器 ServerSocket，指定端口号
        ServerSocket server = new ServerSocket(8888);

        // 服务器一直处于监听状态
        while (true) {
            // 调用 accept 方法获取到请求的客户端对象(浏览器发起)
            Socket socket = server.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        // 调用 Socket 中的 getInputStream 方法获取网络字节输入流
                        InputStream is = socket.getInputStream();

                        // 调用网络字节输入流 InputStream 中的 read 方法，读取浏览器请求的信息
//                        byte[] bytes = new byte[1024];
//                        int len = 0;
//                        while ((len = is.read(bytes)) != -1) {
//                            System.out.println(new String(bytes, 0, len));
//                        }

                        // 将网络字节流转换为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        // 读取客户端请求信息的第一行，获取访问路径
                        String line = br.readLine();

                        // 字符串切割获取路径
                        String[] arr = line.split(" ");
                        // 去掉路径前面的 /
                        String path = arr[1].substring(1);

                        System.out.println("访问路径：" + path);

                        // 服务器通过访问路径，读取本地文件
                        FileInputStream fis = new FileInputStream(path);

                        // 调用 Socket 中的 getOutputStream 方法获取网络字节输出流
                        OutputStream os = socket.getOutputStream();

                        // 调用 OutputStream 中的 write 方法，回写 HTTP 头
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Connect-type:text/html\r\n".getBytes());
                        // 必须写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        // 服务器通过访问路径，读取本地文件，回写到客户端
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }

                        // 关闭资源
                        fis.close();
                        socket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();


        }

        // 服务器不必关闭
//        server.close();
    }


}
