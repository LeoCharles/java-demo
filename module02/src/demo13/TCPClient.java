package demo13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * java.net.Socket
 * 此类实现客户端套接字。套接字是两台机器间通信的端点(包含了IP地址和端口号的网络单位)。
 *
 * 构造方法：
 * Socket(String host, int port)：创建一个流套接字并将其连接到指定主机上的指定端口号。
 * 参数：
 * String host：服务器主机名称
 * int port：端口号
 *
 * 成员方法：
 * InputStream getInputStream()：返回此套接字的输入流。
 * OutputStream getOutputStream()：返回此套接字的输出流。
 * void close()：关闭此套接字。
 *
 *
 * 通过 java.net.Socket 实现 TCP 客户端
 * 向服务器发送连接请求，向服务器发送数据，读取服务器回写的数据
 *
 * 实现步骤：
 * 1. 创建一个客户端对象 Socket，构造方法中传入服务器的 IP 地址和端口号
 * 2. 使用 Socket 中的 getOutputStream 方法获取网络字节输出流 OutputStream 对象
 * 3. 使用网络字节输出流 OutputStream 对象中的 write 方法给服务器发送数据
 * 4. 使用 Socket 中的 getInputStream 方法获取网络字节输入流 InputStream 对象
 * 5. 使用网络字节输入流 InputStream 对象中的 read 方法，读取服务器回写的数据
 * 6. 释放资源(Socket)
 *
 *
 * 注意：
 * 1. 客户端和服务端进行交互时，必须使用 Socket 中提供的网路流
 * 2. 创建 Socket 对象时，会请求服务器进行3次握手建立连接，如果服务器没有启动，会抛出异常
 *
 */

public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("准备发送数据...");
        // 1. 创建 Socket 对象，传入 IP 地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);

        // 2. 调用 Socket 中的 getOutputStream 方法获取网络字节输出流
        OutputStream os = socket.getOutputStream();

        // 3. 调用字节输出流中的 write 方法，写入数据
        os.write("你好，服务器，这是发送的数据".getBytes());

        // 4. 调用 Socket 中的 getInputStream 方法获取网络字节输入流
        InputStream is = socket.getInputStream();

        // 5 调用字节输入流的 read 方法，读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes); // 一次性读取数据
        System.out.println(new String(bytes, 0, len));

        // 6. 释放资源
        socket.close();
    }
}
