package demo09;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符输出流
 *
 * java.io.Writer 抽象类是所有字符输出流的超类
 *
 * 字符输出流共性方法：
 * void write(int c)：写入单个字符。
 * void write(char[] arr)：写入字符数组。
 * abstract void write(char[] arr, int off, int len)：写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
 * void write(String str)：写入字符串。
 * void write(String str, int off, int len)：写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 * void flush()：刷新该流的缓冲。
 * void close() 关闭此流，但要先刷新它。
 *
 * 子类：
 * BufferedWriter：带缓冲的字符输出流
 * CharArrayWriter：字符数组输入流
 * FilterWriter：带过滤器输出流
 * OutputStreamWriter：转换流
 * PipedWriter：管道流
 * PrintWriter：打印输出流
 * StringWriter：字符串流
 *
 * java.io.FileWriter extends OutputStreamWriter extends Writer
 * FileWriter 文件字符输出流
 *
 * 构造方法：
 * FileWriter(File file)：根据给定的 File 对象构造 FileWriter 对象。
 * FileWriter(String fileName)：根据给定的文件名构造 FileWriter 对象。
 * FileWriter(File file, boolean append)：根据给定的 File 对象构造 FileWriter 对象。
 * FileWriter(String fileName, boolean append)：根据给定的文件名构造 FileWriter 对象。
 * 参数：
 * boolean append ：表示是否追加续写。true 不会覆盖原文件，在原文件末尾追加续写。false 覆盖原文件。
 *
 * 使用步骤：
 * 1. 创建 FileWriter 对象，构造方法中传入要写入的目的地
 * 2. 调用 FileWriter 中的 write 方法，把数据写入到内存缓冲区中
 * 3. 调用 FileWriter 中的 flush 方法，把数据从缓冲区刷入磁盘文件
 * 4. 释放资源（会先调用 flush 方法）
 *
 * 关闭和刷新
 * flush：刷新缓冲区，流对象可以继续使用。
 * close：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
 *
 *
 *
 *
 */
public class WriterTest {
    public static void main(String[] args) throws IOException {
//        testWriteOne();
//        testWriteChars();
        testWriteAppend();

    }


    // 一次写一个字符
    public static void testWriteOne() throws IOException {
        FileWriter fw = new FileWriter("module02\\src\\demo09\\test.txt");

        // write(int c) 一次写一个字符
        // 把数据写入内存缓冲区
        fw.write(97);
        // 调用 flush 把缓冲区的数据刷入磁盘
        fw.flush();

        fw.write(98);
        fw.flush();

        fw.write(99);
        fw.flush();

        // 释放资源之前，也会把缓冲区的数据刷入磁盘文件
        fw.close();
    }

    // 一次写入多个字符
    public static void testWriteChars() throws IOException {
        FileWriter fw = new FileWriter("module02\\src\\demo09\\test.txt");

        // write(char[] arr) 写入全部字符数组
        char[] cs = {'你', '好', '！', 'L', 'e', 'o'};
        fw.write(cs); // 写入全部数组

        // write(char[] arr, int off, int len) 写入部分字符数组
        fw.write(cs, 0, 2);

        // write(String str) 写入字符串
        fw.write("hello!");


        // write(String str, int off, int len) 写入部分字符串
        fw.write("hello!", 0, 1);

        // 刷入磁盘文件并释放资源
        fw.close();
    }

    // 追加续写
    public static void testWriteAppend() throws IOException {
        FileWriter fw = new FileWriter("module02\\src\\demo09\\test.txt", true);

        // 系统不同，换行符不同
        // windows: \r\n
        // linux: /n
        // mac: /r

        for (int i = 0; i < 10; i++) {
            fw.write("hello!" + i + "\r\n");
        }

        fw.close();
    }
}
