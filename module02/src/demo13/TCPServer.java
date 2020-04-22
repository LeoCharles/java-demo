package demo13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 通过 java.net.ServerSocket 实现 TCP 服务端
 * 接收客户端的请求，读取客户端发送的数据，给客户端回写数据
 *
 * 实现步骤：
 * 1. 创建服务器 ServerSocket 对象，指定端口号
 * 2. 使用 ServerSocket 对象中的 accept 方法，获取请求的客户端 Socket 对象
 * 3. 使用 Socket 对象中的 getInputStream 方法获取网络字节输入流 InputStream 对象
 * 4. 使用网络字节输入流中的 read 方法，读取客户端发送的数据
 * 5. 使用 Socket 对象中的 getOutputStream 方法获取网络字节输出流 OutputStream 对象
 * 6. 使用网络字节输出流中的 write 方法，给客户端回写数据
 * 7. 释放资源(Socket, ServerSocket)
 *
 *
 */

public class TCPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动，等待连接...");

        // 1. 创建服务器 ServerSocket 对象，指定端口号
        ServerSocket server = new ServerSocket(8888);

        // 2. 获取客户端 Socket 对象
        Socket socket = server.accept();

        // 3. 获取 Socket 中的 InputStream
        InputStream is = socket.getInputStream();

        // 4. 调用 InputStream 中的 read 方法读取数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes); // 一次性读取数据
        System.out.println(new String(bytes, 0, len));

        // 5. 获取 Socket 中的 OutputStream
        OutputStream os = socket.getOutputStream();

        // 6. 调用 OutputStream 中的 write 方法回写数据
        os.write("服务器收到数据，谢谢客户端".getBytes());

        // 7. 释放资源
        socket.close();
        server.close();

        System.out.println("服务端连接关闭");
    }
}
