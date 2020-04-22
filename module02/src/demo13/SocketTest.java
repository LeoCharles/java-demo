package demo13;

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
 * java.net.ServerSocket
 * 此类实现服务器套接字。服务器套接字等待请求通过网络传入。它基于该请求执行某些操作，然后可能向请求者返回结果。
 *
 * 构造方法
 * ServerSocket(int port)：创建绑定到特定端口的服务器套接字。
 *
 * 成员方法：
 * Socket accept()：侦听并接受到此套接字的连接。
 * 服务端通过 accept 方法获取客户端 Socket 对象，从而确定是哪个客户端发起的请求。
 *
 * 
 *
 *
 *
 */

public class SocketTest {
    public static void main(String[] args) {

    }
}
