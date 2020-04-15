package demo10;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * BufferedInputStream extends FilterInputStream extends InputStream 字节缓冲输入流
 *
 * 成员变量：
 * protected  byte[] buf 存储数据的内部缓冲区数组。
 *
 * 构造方法：
 * public BufferedInputStream(InputStream in)：创建一个 新的缓冲输入流。
 * public BufferedInputStream(InputStream in, int size) ： 创建一个新的缓冲输入流，指定缓冲去大小。
 * 参数：
 * InputStream in：字节输入流
 * int size：缓冲区大小
 *
 * 使用步骤：
 * 1. 创建 FileInputStream 对象，构造方法中传入要读取的数据源
 * 2. 创建 BufferedInputStream 对象，构造方法张传入 FileInputStream 对象
 * 3. 调用 read 方法，读取文件
 * 4，释放资源
 *
 */

public class BufferedInputStreamTest {
    public static void main(String[] args) throws IOException {
        testCreate();
    }

    public static void testCreate() throws IOException {
        // 创建 FileInputStream 对象
        FileInputStream fis = new FileInputStream("module02\\src\\demo10\\test.txt");

        // 创建 BufferedInputStream 对象
        BufferedInputStream bis = new BufferedInputStream(fis);

        // read 读取一个字节
//        int len = 0; // 每次读取的一个字节(int 整数表示)
//        while ((len = bis.read()) != -1) {
//            System.out.println(len);
//
//        }

        // read(byte[] b) 读取多个字节
        byte[] bytes = new byte[1024]; // 存储每次读取的数据
        int len = 0; // 每次读取的有效字节数
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        // 释放资源
        bis.close();
    }
}
