package demo05;

import java.io.IOException;

/**
 * 捕获异常 try-catch
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
 * 2. 如果 try 中产生了异常，就会执行 catch，然后继续执行 try-catch 之后的代码
 *
 * Throwable 类中定义的异常处理方法：
 * public String getMessage()：获取异常的描述信息
 * public String toString()：获取异常的类型和异常描述信息
 * public void printStackTrace()：打印异常的跟踪栈信息并输出到控制台(最全面)
 *
 *
 * finally 关键字
 * 有一些特定的代码无论异常是否发生，都需要执行
 * finally 关键字就是解决这个问题，在 finally 代码块中存放的代码都是一定会被执行的
 *
 * finally 不能单独使用
 *
 * 格式:
 *
 * try {
 *     // ...
 * } catch {
 *     // ...
 * } finally {
 *     // 一定会执行的代码
 * }
 *
 * 在 try 语句块中打开了一些物理资源(磁盘文件/网络连接/数据库连接等)
 * 我们都得在使用完之后, 可以在 finally 中关闭打开的资源
 *
 */
public class TryCatchTest {
    public static void main(String[] args) {
        // 使用 try-catch 处理异常
        try {
            readFile("c:\\a.doc");
        } catch (IOException e) {
//            System.out.println(e.getMessage()); // 文件的后缀名不正确
//            System.out.println(e.toString()); // java.io.IOException: 文件的后缀名不正确
            e.printStackTrace();
        } finally {
            System.out.println("不管是否有异常都会执行");
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
