package demo13;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP 客户端
 * 向服务器发送连接请求，向服务器发送数据，读取服务器回写的数据
 *
 * 创建步骤：
 * 1. 创建一个客户端对象 Socket，构造方法中传入服务器的 IP 地址和端口号
 * 2. 使用 Socket 中的 getOutputStream 方法获取网络字节输出流 OutputStream 对象
 * 3. 使用网络字节输出流 OutputStream 对象中的 write 方法给服务器发送数据
 * 4. 使用 Socket 中的 getInputStream 方法获取网络字节输入流 InputStream 对象
 * 5. 使用网络字节输入流 InputStream 对象中的 read 方法，读取服务器回写的数据
 * 6. 释放资源
 *
 *
 * 注意：
 * 1. 客户端和服务端进行交互时，必须使用 Socket 中提供的网路流
 * 2. 创建 Socket 对象时，会请求服务器进行3次握手建立连接，如果服务器没有启动，会抛出异常
 *
 */

public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 1. 创建 Socket 对象，传入 IP 地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);

        // 2. 调用 getOutputStream 方法获取网络字节输出流
        OutputStream os = socket.getOutputStream();

        // 3. 调用字节输出流中的 write 方法，写入数据
        os.write("你好，服务器".getBytes());


        // 释放资源
        socket.close();
    }
}
