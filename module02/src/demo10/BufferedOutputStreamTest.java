package demo10;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedOutputStream extends FilterOutputStream extends OutputStream 字节缓冲输出流
 *
 * 成员变量：
 * protected  byte[] buf 存储数据的内部缓冲区。
 *
 * 构造方法：
 * BufferedOutputStream(OutputStream out)：创建一个新的缓冲输出流，以将数据写入指定的底层输出流。
 * BufferedOutputStream(OutputStream out, int size) ：创建一个新的缓冲输出流，指定缓冲区大小。
 * 参数：
 * OutputStream out：字节输出流，可以传 FileOutputStream，提高 FileOutputStream 写入效率
 * int size：缓冲区数组大小
 *
 * 使用步骤：
 * 1. 创建 FileOutputStream 对象，构造方法中传入输出的目的地
 * 2. 创建 BufferedOutputStream 对象，构造方法中传入 FileOutputStream 对象
 * 3. 调用 write 方法，把数据写入内部的缓冲区
 * 4. 调用 flush 方法，把缓冲区的数据刷到文件中
 * 5. 释放资源(会先调用 flush 方法)
 *
 *
 *
 */

public class BufferedOutputStreamTest {
    public static void main(String[] args) throws IOException {
        testCreate();
    }

    public static void testCreate() throws IOException {
        // 创建 FileOutputStream 对象，构造方法中传入要输出的目的地
        FileOutputStream fos = new FileOutputStream("module02\\src\\demo10\\test.txt");

        // 创建 BufferedOutputStream 对象，构造方法中传入 FileOutputStream 对象
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        // 调用 write 方法
        bos.write("把数据写入内部缓存区".getBytes());

        // 调用 flush 方法将数据刷入文件
        bos.flush();


        // 释放资源
        bos.close();
    }
}
