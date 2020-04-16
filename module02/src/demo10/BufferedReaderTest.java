package demo10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader extends Reader 字符缓冲输入流
 *
 * 构造方法：
 * BufferedReader(Reader in)：创建一个使用默认大小输入缓冲区的缓冲字符输入流。
 * BufferedReader(Reader in, int sz)：创建一个使用指定大小输入缓冲区的缓冲字符输入流。
 * 参数：
 * Reader in：字符输入流
 * int sz：缓冲区大小
 *
 * 继承自父类的方法：
 * public int read()：读取单个字符并返回字符的 int 类型整数形式。
 * public int read(char[] arr)：将字符读入数组。
 * public void close()：关闭此流并释放与此流相关联的任何系统资源。
 *
 * 特有方法：
 * String readLine()：读取一个文本行，返回一行数据(不包含换行符)。读到末尾返回 null。
 *
 * 使用步骤：
 * 1. 创建 BufferedReader 对象，构造方法中传入字符输入流对象
 * 2. 调用 read / readLine 方法，读取文本
 * 3. 释放资源
 *
 */

public class BufferedReaderTest {
    public static void main(String[] args)  throws IOException {
        testCreate();
    }

    public static void testCreate() throws IOException {
        // 创建字符缓冲输出流对象
        BufferedReader br = new BufferedReader(new FileReader("module02\\src\\demo10\\test.txt"));

        // readline 读取一行文本
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        // 释放资源
        br.close();
    }
}
