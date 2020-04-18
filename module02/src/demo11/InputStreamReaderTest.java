package demo11;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.InputStreamReader extends Reader
 * InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。
 *
 * 继承自父类的成员方法：
 * int read()：读取单个字符并返回字符的 int 类型整数形式。
 * int read(char[] arr)：将字符读入数组。
 * void close()：关闭此流并释放与此流相关联的任何系统资源。
 *
 * 构造方法：
 * InputStreamReader(InputStream in)：创建一个使用默认字符集的 InputStreamReader。
 * InputStreamReader(InputStream in, String charsetName)：创建使用指定字符集的 InputStreamReader。
 * 参数：
 * InputStream in：字节输入流
 * String charsetName：字符集，不区分大小，默认使用 UTF-8
 *
 * 使用步骤：
 * 1. 创建 InputStreamReader 对象，构造方法中传入字节输入流和指定的编码表名称
 * 2. 调用 read 方法读取文件
 * 3. 释放资源
 *
 * 注意事项：
 * 构造方法中指定的编码表名称要和文件的编码相同，否则会乱码
 *
 *
 */

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
//        readUTF8();
        readGBK();
    }

    // 读取 UTF-8 格式文件
    public static void readUTF8() throws IOException {
        // 创建 InputStreamReader 对象，传入字节输入流和编码表名称，默认 UTF-8
        InputStreamReader isr = new InputStreamReader(new FileInputStream("module02\\src\\demo11\\utf_8.txt"));

        // 调用 read 方法
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.println(len + "-->" + (char) len);
        }

        // 释放资源
        isr.close();
    }

    // 读取 GBK 格式文件
    public static void readGBK() throws  IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("module02\\src\\demo11\\gbk.txt"), "gbk");

        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.println(len + "-->" + (char) len);
        }

        isr.close();
    }
}
