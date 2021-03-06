package demo09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO 流
 *
 * IO 流是一种顺序读写数据的模式，特点是单向流动。数据类似自来水一样在水管中流动，称为IO流。
 *
 * IO 是指 Input/Output，即输入和输出。以内存为中心：
 * Input 输入，从外部读入数据到内存。例如，把文件从磁盘读取到内存，从网络读取数据到内存等等。
 * Output 输出，把数据从内存输出到外部。例如，把数据从内存写入到文件，把数据从内存输出到网络等等。
 *
 * 因为代码是在内存中运行的，所以数据也必须读到内存，代码才能处理这些数据。
 * 因为内存有“易失性”的特点，所以必须把处理后的数据以某种方式输出，例如，写入到文件。
 *
 * IO 流以字节(byte)为最小单位，也称为字节流。
 *
 * InputStream 字节输入流，把字节从磁盘文件读入内存
 * OutputStream 字节输出流，把字节从内存写入磁盘文件
 *
 * 如果读写的是字符(char)，这种流称为字符流。
 * Reader 字符输入流
 * Writer 字符输出流
 *
 * Reader 和 Writer本质上是一个能自动编解码的 InputStream 和 OutputStream。
 *
 * 1个字符 = 2个字节，1个字节 = 8个二进制位。
 *
 * 同步 IO 是指，读写 IO 时，代码必须等待数据返回后才继续执行后续代码
 * 优点：代码编写简单；缺点：CPU执行效率低。
 *
 * 异步 IO 是指，读写 IO 时仅发出请求，然后立刻执行后续代码。
 * 优点：CPU执行效率高，缺点：代码编写复杂。
 *
 * java.io 提供了同步 IO，而 java.nio 则是异步 IO
 *
 * InputStream、OutputStream、Reader 和 Writer 都是同步 IO 的抽象类
 *
 *
 * IO异常处理
 * JDK 1.7 之前使用  try...catch...finally 代码块，处理异常
 * 格式：
 * try {
 *     可能会产出异常的代码
 * } catch (异常类 变量名) {
 *     处理异常
 * } finally {
 *     一定会执行的代码
 *     释放资源
 * }
 *
 * JDK 1.7 之后，可以使用  try-with-resource 语句
 * 在 try 后面加一个括号，在括号中定义流对象，try中的代码执行完毕，会自动把流对象释放，不用谢 finally
 * 格式：
 * try (定义流对象; 定义流对象; ...) {
 *     可能会出现异常的代码
 * } catch (异常类 变量名) {
 *     处理异常
 * }
 *
 *
 */
public class MainIO {
    public static void main(String[] args) throws IOException {
//        copyFile();
//        testException();
        testHandleException();
    }

    // 复制文件
    // 步骤：
    // 1. 创建一个字节输入流对象，构造方法中传入要读取的数据源
    // 2. 创建一个字节输出流对象，构造方法中传入要写入的目的地
    // 3. 使用字节输入流中的 read 方法读取文件
    // 4. 使用字节输出流中的 write 方法把读取到的字节写入到目的地文件
    // 5. 释放资源
    public static void copyFile() throws IOException {
        long s = System.currentTimeMillis();

        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("module02\\src\\demo09\\java.png");
        // 创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("module02\\src\\demo09\\java_copy.png");

        // 读取一个字节写入一个字节
//        int len = 0;
//        // 读取一个字节
//        while ((len = fis.read()) != -1 ) {
//            // 写入一个字节
//            fos.write(len);
//        }

        // 一次读写一个字节效率低，创建一个缓冲区，一次读写多个字节
        byte[] bytes = new byte[1024];
        // 每次读取的有效字节个数
        int len = 0;
        // 循环读取
        while ((len = fis.read(bytes)) != -1) {
            // 从字节数组索引 0 开始，写入有效字节个数
            fos.write(bytes, 0, len);
        }

        // 释放资源(先关闭写，在关闭读)
        fos.close();
        fis.close();

        long e = System.currentTimeMillis();
        System.out.println("复制文件共耗时：" + (e - s) + "毫秒");
    }

    // try...catch...finally 处理异常
    public static void testException () {
        // 提高变量作用域，并初始化
        FileWriter fw = null;
        try {
            // 如果创建失败，则 fw就没有值，fw.close()就会报错
            fw = new FileWriter("module02\\src\\demo09\\test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // null 不能调用close方法
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //  使用 try-with-resource 语句
    public static void testHandleException() {
        // jdk 1.7 定义流对象，使用完后自动释放，不需要 调用 close() 方法
        try (
            FileInputStream fis = new FileInputStream("module02\\src\\demo09\\java.png");
            FileOutputStream fos = new FileOutputStream("module02\\src\\demo09\\java_copy.png")
        ) {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
