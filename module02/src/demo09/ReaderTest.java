package demo09;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 *
 * 使用字节流读取中文字符时，会出现乱码
 * GBK编码：1个中文占2个字节
 * UTF-8编码：1个中文占3个字节
 *
 * 使用字符输入流可以解决这个问题，字符输入流以字符(char)为单位读取
 *
 * java.io.Reader 抽象类是所有字符输入流的超类
 *
 * 字符输入流共性方法：
 * public int read()：读取单个字符并返回字符的 int 类型整数形式。
 * public int read(char[] arr)：将字符读入数组。
 * public void close()：关闭此流并释放与此流相关联的任何系统资源。
 *
 * 子类：
 * BufferedReader：带缓冲的字符输入流
 * CharArrayReader：读取字符数组的流
 * FilterReader：带过滤器的字符输入流
 * InputStreamReader：转换流
 * PipedReader：管道流
 * StringReader：读取字符串的流
 *
 *
 * java.io.FileReader extends InputStreamReader extends Reader
 * FileReader：字符文件输入流，把磁盘文件中的数据以字符的方式读取到内存中
 *
 * 构造方法：
 * FileReader(File file)：创建一个新的 FileReader ，给定要读取的File对象。
 * FileReader(String fileName)：创建一个新的 FileReader ，给定要读取的文件的名称
 *
 * 使用步骤：
 * 1. 创建 FileReader 对象，构造方法中传入要读取的数据源
 * 2. 使用 FileReader 中 read 方法，读取文件
 * 2. 释放资源
 *
 *
 */

public class ReaderTest {
    public static void main(String[] args) throws IOException{
//        testInputStreamChinese();
//        testReadOne();
        testReadChars();
    }

    // 读取中文文件
    public static void testInputStreamChinese() throws IOException {
        // 使用字节输入流读取中文文件
        FileInputStream fis = new FileInputStream("module02\\src\\demo09\\测试.txt");
        // UTF-8 格式文件，一个中文字符占3个字节
        // 如果一个字节一个字节读取中文字符，会出现乱码
        byte[] bytes = new byte[3];
        // 读取的有效字节数
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
    }

    // 一次读取单个字符
    public static void testReadOne() throws IOException {
        // 创建 FileReader 对象
        FileReader fr = new FileReader("module02\\src\\demo09\\测试.txt");

        // 一次读取一个字符
        int len = 0;
        while ((len = fr.read()) != -1) {
            // int 类型强转成 char
            System.out.print((char) len);
        }

        // 释放资源
        fr.close();
    }

    // 一次读取多个字符
    public static void testReadChars() throws IOException {
        FileReader fr = new FileReader("module02\\src\\demo09\\测试.txt");

        // read(char[] arr) 将字符读入到数组
        // 字符缓冲区
        char[] chars = new char[1024];
        int len = 0; // 读取的有效字符个数

        while((len = fr.read(chars)) != -1) {
            // 将字符数组转成字符串
            System.out.println(new String(chars, 0, len));
        }

        // 释放资源
        fr.close();
    }

}
