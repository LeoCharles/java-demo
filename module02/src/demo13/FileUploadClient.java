package demo13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传客户端
 *
 * 读取本地文件，上传到服务器，再读取服务器回写的数据
 *
 * 数据源：客户端的硬盘
 * 目的地：服务器
 *
 * 实现步骤：
 * 1. 创建本地字节输入流 FileInputStream 对象，构造方法中传入数据源
 * 2. 创建客户端 Socket 对象，构造方法中传入服务器的 IP 和端口号
 * 3. 使用 Socket 中的 getOutputStream 方法获取网络字节输出流 OutputStream 对象
 * 4. 使用本地字节输入流 FileInputStream 对象中的 Read 方法，读取本地文件
 * 5. 使用网络字节输出流 OutputStream 对象中的 write 方法，把读取到的本地文件上传到服务器
 * 6. 使用 Socket 对象中的 getInputStream 方法获取网络字节输入流 InputStream 对象
 * 7. 使用网络字节输入流 InputStream 对象中的 read 方法，读取服务器回写的数据
 * 8. 释放资源(FileInputStream, Socket)
 *
 *
 */

public class FileUploadClient {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        // 1. 创建本地字节输入流 FileInputStream 对象
        FileInputStream fis = new FileInputStream("module02\\src\\demo13\\java.png");

        // 2. 创建客户端 Socket 对象
        Socket socket = new Socket("127.0.0.1", 8888);

        // 3. 使用 Socket 中的 getOutputStream 方法获取网络字节输出流 OutputStream
        OutputStream os = socket.getOutputStream();

        // 4. 使用 FileInputStream 中的 Read 方法，读取本地文件
        byte[] bytes = new byte[1024];
        int len = 0;
        // read 方法不会读取结束标记，也不会把结束标记写入字节输出流，会导致阻塞
        while ((len = fis.read(bytes)) != -1) {
            // 5. 使用 OutputStream 中的 write 方法，把读取到的本地文件上传到服务器
            os.write(bytes, 0, len);
        }
        // 结束输出流
        socket.shutdownOutput();

        // 6. 使用 Socket 中的 getInputStream 方法获取网络字节输入流 InputStream
        InputStream is = socket.getInputStream();

        // 7. 使用 InputStream 中的 read 方法，读取服务器回写的数据
        while((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        // 8. 释放资源
        fis.close();
        socket.close();

        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start) + "毫秒");
    }
}
