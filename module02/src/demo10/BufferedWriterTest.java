package demo10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter extends Writer 字符缓冲输出流
 *
 * 构造方法：
 * BufferedWriter(Writer out):创建一个使用默认大小输出缓冲区的缓冲字符输出流。
 * BufferedWriter(Writer out, int sz): 创建一个使用给定大小输出缓冲区的新缓冲字符输出流。
 * 参数：
 * Writer out： 字符输出流
 * int sz: 缓冲区大小
 *
 * 继承自父类的方法：
 * void write(int c)：写入单个字符。
 * void write(char[] arr)：写入字符数组。
 * abstract void write(char[] arr, int off, int len)：写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
 * void write(String str)：写入字符串。
 * void write(String str, int off, int len)：写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 * void flush()：刷新该流的缓冲。
 * void close() 关闭此流，但要先刷新它。
 *
 * 特有方法：
 * void newLine(): 写入一个行分隔符。根据不同的操作系统，获取不同的行分隔符。
 *
 * 使用步骤：
 * 1. 创建 BufferedWriter 对象，构造方法中传入字符输出流对象
 * 2. 调用 write 方法，把数据写入内存中的缓冲区中
 * 3. 调用 flush 方法，将数据刷入文件中
 * 4. 释放资源
 *
 */

public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        testCreate();
    }

    public static void testCreate() throws IOException {
        // 创建字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("module02\\src\\demo10\\test.txt"));

        // write 方法写入数据
        for (int i = 0; i < 10; i++) {
            bw.write("测试字符缓冲输出流" + i);
            // 写入一个换行符
            bw.newLine();
        }

        // flush 将数据刷入文件
        bw.flush();

        // 释放资源
        bw.close();
    }
}
