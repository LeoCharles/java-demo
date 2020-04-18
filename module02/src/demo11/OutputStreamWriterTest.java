package demo11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java.io.OutputStreamWriter extends Writer 转换流
 * OutputStreamWriter 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节。
 *
 * 继承自父类的成员方法：
 * void write(int c)：写入单个字符。
 * void write(char[] arr)：写入字符数组。
 * abstract void write(char[] arr, int off, int len)：写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
 * void write(String str)：写入字符串。
 * void write(String str, int off, int len)：写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 * void flush()：刷新该流的缓冲。
 * void close() 关闭此流，但要先刷新它。
 *
 * 构造方法：
 * OutputStreamWriter(OutputStream out)：创建使用默认字符编码的 OutputStreamWriter。
 * OutputStreamWriter(OutputStream out, String charsetName)：创建使用指定字符集的 OutputStreamWriter。
 * 参数：
 * OutputStream out：字节输出流
 * String charsetName：字符集，不区分大小，默认使用 UTF-8
 *
 * 使用步骤：
 * 1. 创建 OutputStreamWriter 对象，构造方法中传入字节输出流对象和字符集名称。
 * 2. 调用 write 方法，把字符转换成字节(编码)，存储在缓冲区
 * 3. 调用 flush 方法，把内存中缓冲区中的字节刷入到文件中
 * 4. 释放资源
 *
 */

public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
//        writeUTF8();
        writeGBK();
    }

    // 使用转换流写 UTF-8 格式的文件
    public static void writeUTF8() throws IOException {
        // 创建转换流对象，传入字节输出流和编码表名称，默认 UTF-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("module02\\src\\demo11\\utf_8.txt"), "utf-8");

        // 调用 write 方法，把字符转换为字节，存储在缓冲区中
        osw.write("这是UTF-8格式的文件");

        // 调用 flush 方法，把内存缓冲区的字节刷入文件中
        osw.flush();

        // 释放资源
        osw.close();
    }

    // 使用转换流写 GBK 格式的文件
    public static void writeGBK() throws IOException {
        // 创建转换流对象，传入字节输出流和编码表名称
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("module02\\src\\demo11\\gbk.txt"), "gbk");

        // 调用 write 方法，把字符转换为字节
        osw.write("这是GBK格式的文件");

        // 调用 flush 方法，把内存中字节刷入文件中
        osw.flush();

        // 释放资源
        osw.close();
    }

}
