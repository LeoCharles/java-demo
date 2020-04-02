package demo05;

import java.io.IOException;

/**
 * 捕获异常 try... catch
 *
 * 格式：
 *
 * try {
 *     可能产生异常的代码
 * } catch (异常类型 变量名) {
 *     异常的处理逻辑，一般会把异常记录到一个日志中
 * } catch (异常类型 变量名) {
 *     ...
 * }
 *
 * 注意:
 * 1. try 中可以抛出多个异常，可以使用多个 catch 捕获
 * 2. 如果 try 中产生了异常，就会执行 catch，然后继续执行 try...catch 之后的代码
 *
 *
 *
 */
public class TryCatchTest {
    public static void main(String[] args) {
        // 使用 try...catch 处理异常
        try {
            readFile("c:\\a.doc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("后续代码");
    }

    public static void readFile(String fileName) throws IOException {
        // 判断是否为 .txt 文件
        if (!fileName.endsWith(".txt")) {
            // 抛出 IO 异常
            throw new IOException("文件的后缀名不正确");
        }
    }

}
