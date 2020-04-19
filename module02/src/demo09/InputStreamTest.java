package demo09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * InputStream 字节输入流
 *
 * java.io.InputStream 抽象类是所有字节输入流的超类
 *
 * 字节输入流共性方法：
 * abstract int read()：从输入流读取数据的下一个字节。
 * int read(byte[] b)：从输入流中读取一些字节数，并将它们存储到字节数组 b中。
 * void close()：关闭此输入流并释放与此流相关联的任何系统资源。
 *
 * 子类：
 * AudioInputStream：读取音频
 * ByteArrayInputStream：读取字节数组
 * FileInputStream： 读取文件
 * FilterInputStream：带过滤器的字节输入流
 * ObjectInputStream：读取对象，反序列化流
 * PipedInputStream：管道输入流
 * SequenceInputStream：队列输入流
 * StringBufferInputStream：读取字符串缓冲区
 *
 * java.io.FileInputStream extends InputStream 文件字节输入流，从磁盘文件中读取字节到内存。
 *
 * 构造方法：
 * FileInputStream(File file) ：通过打开与实际文件的连接来创建一个 FileInputStream，该文件由文件系统中的 File对象 file命名
 * FileInputStream(String name) ：通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名
 * 参数：
 * File file / String name：读取文件的数据源
 *
 * 构造方法的作用：
 * 1. 创建一个 FileInputStream 流对象
 * 2. 根据传入的参数创建 File 对象
 * 3. 把 FileInputStream 流对象指向 File 对象
 *
 * 从磁盘文件读取到内存的原理：
 * java程序 --> JVM(java虚拟机) --> OS(操作系统) --> OS调用方法读取文件到内存
 *
 * 文件字节输入流的使用步骤：
 * 1. 创建 FileInputStream 对象，构造方法中传入要读取的文件
 * 2. 调用 read 方法，读取文件到内存
 * 3. 释放资源
 *
 *
 */

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
//        testReadOne();
        testReadBytes();

    }

    // 一次读取单个字节
    public static void testReadOne() throws IOException {
        // 创建 FileInputStream 对象
        FileInputStream fis = new FileInputStream("module02\\src\\demo09\\abc.txt");
        // int read() 读取输入流的下一个字节，并返回字节表示的 int  值
        // 如果已读到末尾，返回-1表示不能继续读取了
//        int i = fis.read(); // int 表示的字节
//        System.out.println(i);
//
//        i = fis.read();
//        System.out.println(i);
//
//        i = fis.read();
//        System.out.println(i);
//
//        i = fis.read();
//        System.out.println(i);

        // 读取文件是一个重复的过程，使用循环

        int b; // 记录读取到的字节

        while ((b = fis.read()) != -1) {
            System.out.println(b);
            // 整数转换成字符
            System.out.println((char) b);
        }

        // 释放资源
        fis.close();
    }

    // int read(byte[] b) 读取多个字节
    // 参数 byte 数组是缓冲区，存储每次读取的多个字节，一般设置为 1024(1kb)
    // 返回值表示每次读取的有效字节个数
    public static void testReadBytes() throws IOException {
        FileInputStream fis = new FileInputStream(new File("module02\\src\\demo09\\abc.txt"));

        // int read(byte[] b) 读取若干字节并填充到byte[]数组，返回读取的字节数

        // 先创建一个字节数组作为缓冲区
//        byte[] bytes = new byte[2];
//
//        // 记录读取到的有效字节数
//        int len = fis.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes));
//
//        len = fis.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes));
//
//        len = fis.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes));

        // 读取是一个重复过程，使用循环

        byte[] bytes = new byte[1024]; // 缓冲区，存储读取的多个字节
        int len = 0; // 读取字节的个数
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(len);
            // 将有效的字节转成字符串
            // String(byte[] bytes, int offset, int length)
            System.out.println(new String(bytes, 0, len));
        }

        // 释放资源
        fis.close();
    }
}
