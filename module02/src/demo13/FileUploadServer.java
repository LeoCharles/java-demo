package demo13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 文件上传服务端
 *
 * 读取客户端上传的文件，保存到服务器硬盘，给客户端回写数据，提示上传成功
 *
 * 数据源：客户端上传的文件
 * 目的地：服务器的硬盘
 *
 * 实现步骤：
 * 1. 创建服务器 ServerSocket 对象，指定端口号
 * 2. 使用 ServerSocket 对象中的 accept 方法，获取请求的客户端 Socket 对象
 * 3. 使用 Socket 对象中的 getInputStream 方法，获取网络字节输入流 InputStream 对象
 * 4. 判断目的地文件夹是否存在，如果不存在则创建
 * 5. 创建本地字节输出流 FileOutputStream 对象，构造方法中传入输出的目的地
 * 6. 使用网络字节输入流 InputStream 对象中的 read 方法，读取客户端上传的文件
 * 7. 使用本地字节输出流 FileOutputStream 对象中的 write 方法，把读取到的文件写出到服务器硬盘
 * 8. 使用 Socket 对象中的 getOutputStream 方法，获取网络字节输出流 OutputStream 对象
 * 9. 使用网络字节输出流 OutputStream 对象中的 write 方法，给客户端回写数据，提示上传成功
 * 10. 释放资源(FileOutputStream, ServerSocket, Socket)
 *
 *
 */

public class FileUploadServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动，等待连接中...");
        // 1. 创建服务器 ServerSocket 对象，指定端口号
        ServerSocket server = new ServerSocket(8888);

        // 服务器一直处于监听状态，不用关闭
        while (true) {

            // 2. 使用 ServerSocket 对象中的 accept 方法，获取请求的客户端 Socket 对象
            Socket socket = server.accept();

            // 使用多线程技术，每有一个客户端上传文件，就开启一个多线程，提高效率
            new Thread(new Runnable() {
                // 文件上传任务
                @Override
                public void run() {
                    // run 方法不能声明抛出异常，需要捕获异常
                    try {
                        // 3. 使用 Socket 对象中的 getInputStream 方法，获取网络字节输入流 InputStream 对象
                        InputStream is = socket.getInputStream();

                        // 4. 判断目的地文件夹是否存在，如果不存在则创建
                        File file = new File("module02\\src\\demo13\\upload");
                        if (!file.exists()) {
                            file.mkdirs();
                        }

                        // 5. 创建本地字节输出流 FileOutputStream 对象，构造方法中传入输出的目的地
                        // 自定义文件名，防止同名文件被覆盖，规则：域名+毫秒值+随机数
                        String fileName = "upload" + System.currentTimeMillis() + new Random().nextInt(99999) + ".png";
                        FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);

                        // 6. 使用网络字节输入流 InputStream 对象中的 read 方法，读取客户端上传的文件
                        byte[] bytes = new byte[1024];
                        int len = 0;

                        while ((len = is.read(bytes)) != -1) {
                            // 7. 使用本 FileOutputStream 对象中的 write 方法，把读取到的文件写出到服务器硬盘
                            fos.write(bytes, 0, len);
                        }

                        // 8. 使用 Socket 对象中的 getOutputStream 方法，获取网络字节输出流 OutputStream 对象
                        OutputStream os = socket.getOutputStream();

                        // 9. 使用网络字节输出流 OutputStream 对象中的 write 方法，给客户端回写数据，提示上传成功
                        os.write("上传成功".getBytes());

                        // 10. 释放资源
                        fos.close();
                        socket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

        }

        // 不用关闭
//        server.close();
    }
}
