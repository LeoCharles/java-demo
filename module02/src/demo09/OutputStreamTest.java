package demo09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * OutputStream 字节输出流
 *
 * java.io.OutputStream 抽象类是所有字节输出流的超类
 *
 * 字节输出流共性方法
 * public void close()：关闭此输出流并释放与此流相关联的任何系统资源。
 * public void flush()：刷新此输出流并强制任何缓冲的输出字节被写出。
 * public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
 * public void write(byte[] b, int off, int len)：从指定的字节数组写入 len 字节，从偏移量 off 开始输出到此输出流。
 * public abstract void write(int b)：将指定的字节输出流。
 *
 * 子类：
 * ByteArrayOutputStream：字节数组输出流
 * FileOutputStream：文件字节输出流
 * FilterOutputStream：带过滤器的字节输出流
 * ObjectOutputStream：对象输出流
 * PipedOutputStream：管道流
 *
 * java.io.FileOutputStream extends OutputStream，文件字节输出流，把内存中的数据写入磁盘文件中
 *
 * 构造方法：
 * public FileOutputStream(String name) ：创建文件输出流以指定的名称写入文件。
 * public FileOutputStream(File file) ：创建文件输出流以写入由指定的File对象表示的文件。
 * public FileOutputStream(String name, boolean append) ：创建文件输出流以指定的名称写入文件。
 * public FileOutputStream(File file, boolean append) ：创建文件输出流以写入由指定的File对象表示的文件。
 * 参数：
 * String name / File file ：文件写入的目的地。
 * boolean append ：表示是否追加续写。true 不会覆盖原文件，在原文件末尾追加续写。false 覆盖原文件。
 *
 * 构造方法的作用：
 * 1. 创建一个 FileOutputStream 流对象
 * 2. 根据传入的参数创建创建一个文件
 * 3. 把流对象指向创建好的文件
 *
 * 从内存写入数据到文件的原理：
 * java程序 --> JVM(java虚拟机) --> OS(操作系统) --> OS调用写数据的方法，把数据写入文件中
 *
 * 字节输出流的使用步骤：
 * 1. 创建一个 FileOutputStream 流对象，构造方法中传入写入数据的目的地
 * 2. 调用 write 方法，把输出写入到文件中
 * 3. 释放资源
 *
 */

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
//        testWriteOne();
        testWriteBytes();
//        testWriteString();
//        testWriteAppend();
//        testWriteNewLine();

    }

    // 一次写出单个字节
    public static void testWriteOne() throws IOException {
        // 创建一个 FileOutputStream 流对象，构造方法中传入写入数据的目的地
        FileOutputStream fos = new FileOutputStream("module02\\src\\demo09\\test.txt");
        // 调用 write 方法，一次写出一个字节
        // 写出的时候会把十进制转成二进制
        fos.write(97); // 写出第1个字节 97 -> a
        fos.write(98); // 写出第2个字节 98 -> b
        fos.write(99); // 写出第3个字节 99 -> c

        // 释放资源
        fos.close();

        // 任意文本编辑器，在打开文件的时候，会查询编码表，把字节转成字符
        //  0 - 127: 查 ASCII 表；其他的查系统默认码表(中文系统GBK)
    }

    // 一次写出多个字节
    public static void testWriteBytes() throws IOException {
        // 传入一个 File 对象，创建文件对象流
        FileOutputStream fos = new FileOutputStream(new File("module02\\src\\demo09\\test.txt"));
        // 一次写入多个字节
        byte[] bytes1 = {65, 66, 67, 68, 69};
        byte[] bytes2 = {-65, -66, -67, 68, 69};

        // write(byte[] b) 把字节数组全部写入文件中
        fos.write(bytes1); // ABCDE
        fos.write(bytes2); // 烤紻E

        // write(byte[] b, int off, int len) 把字节数据的一部分写入到文件中
        // off：字节数组指定位置，len：写入的长度
        fos.write(bytes1, 1, 2); // 从索引 1 开始，写出两个字节，也就是BC

        // 释放资源
        fos.close();

        // 如果第一个字节是正数(1 - 127)，查询 ASCII表
        // 如果第一个字节是负数，会两个字节一起组成中文(GBK)
    }

    // 字符串写出
    public static void testWriteString() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("module02\\src\\demo09\\test.txt"));

        // 使用 String 类中 getBytes 方法转成字节数组
        byte[] bytes = "你好".getBytes();

        // UTF-8 三个字节组成中文
        System.out.println(Arrays.toString(bytes)); // [-28, -67, -96, -27, -91, -67]
        fos.write(bytes); // 你好

        // 释放资源
        fos.close();
    }

    // 数据追加续写
    public static void testWriteAppend() throws IOException {
        // 第二个参数表示是否覆盖原文件，true 表示不覆盖，在原文件后面追加续写
        FileOutputStream fos = new FileOutputStream("module02\\src\\demo09\\test.txt", true);

        fos.write("你好".getBytes());

        fos.close();
    }

    // 换行写出
    public static void testWriteNewLine() throws IOException {
        FileOutputStream fos = new FileOutputStream("module02\\src\\demo09\\test.txt");

        // 系统不同，换行符不同
        // windows: \r\n
        // linux: /n
        // mac: /r

        for (int i = 0; i < 10; i++) {
            fos.write("你好".getBytes());
            fos.write("\r\n".getBytes()); // 换行符
        }

        fos.close();
    }
}
