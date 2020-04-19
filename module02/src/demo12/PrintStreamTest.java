package demo12;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * java.io.PrintStream extends FilterOutputStream extents OutputStream 打印流
 * PrintStream 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。
 *
 * 打印流特点：
 * 1. 只负责数据输出，不负责数据读取
 * 2. 永远不会抛出 IOException；
 *
 * 特有方法：
 * void print(任意类型的值)
 * void println(任意类型的值)
 *
 * 构造方法：
 * PrintStream(File file)：输出的目的地是一个文件
 * PrintStream(OutputStream out)：输出的目的地是一个字节输出流
 * PrintStream(String fileName)：输出的目的地是一个文件路径
 *
 * 注意事项：
 * 如果使用继承自父类的 write 方法写数据，查看数据的时候会查询编码表
 * 如果使用特有的 print/println 方法写数据，写的数据会原样输出
 *
 * 打印流可以改变流向
 *
 * System.out 是 PrintStream 类型，默认打印到控制台
 * 使用 System.setOut 方法，可以改变流出方向
 * static void setOut(PrintStream out)：重新分配“标准”输出流。
 *
 *
 *
 */

public class PrintStreamTest {
    public static void main(String[] args) throws FileNotFoundException {
//        testPrint();
        testSetOut();
    }

    public static void testPrint() throws FileNotFoundException {
        // 创建打印流
        PrintStream ps = new PrintStream("module02\\src\\demo12\\print.txt");

        // 调用 write 方法，查看数据的时候会查询编码表
        ps.write(97);
        ps.write(98);
        ps.write(99);

        // 调用 print / println 方法，数据原样输出
        ps.print(97);
        ps.print(98);
        ps.print(99);

        // 释放资源
        ps.close();
    }



    public static void testSetOut() throws FileNotFoundException {
        PrintStream ps = new PrintStream("module02\\src\\demo12\\print.txt");

        // 调用 System.setOut 方法，改变输出语句的目的地
        System.setOut(ps);

        System.out.println("原本输出到控制台，现在输出到文件");

        ps.close();
    }
}
