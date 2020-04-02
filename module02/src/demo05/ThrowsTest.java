package demo05;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * throws 关键字
 *
 * 使用 throws 关键字处理异常，把异常抛出给方法的调用者处理
 *
 * 格式：
 * 修饰符 返回值类型 方法名(参数列表) throws AAAException, BBBException, CCCException{
 *     throw new AAAException(异常产生的原因);
 *     throw new BBBException(异常产生的原因);
 *     throw new CCCException(异常产生的原因);
 *     ...
 * }
 *
 * 注意：
 * 1. throws 关键字必须写在方法声明处
 * 2. throws 关键字后面声明的异常必须是 Exception 或它的子类
 * 3. 方法内部如果抛出了多个异常，throws 后面也必须声明多个异常(直接声明父类即可)
 * 4. 调用了一个声明抛出异常的方法，必须处理(try...catch 或者继续 throws)
 *
 */
public class ThrowsTest {
    // 继续抛出异常，让 JVM 处理
    public static void main(String[] args) throws /*FileNotFoundException,*/ IOException {
        readFile("c:\\a.doc");
    }

    // 声明抛出异常
    // FileNotFoundException extends IOException extends Exception
    // 如果抛出的多个异常存在父子类继承关系，直接声明父类异常即可
    public static void readFile(String fileName) throws /*FileNotFoundException, */IOException {

        //判断文件路径不是 "c:\\a.txt"
        if (!fileName.equals("c:\\a.txt")) {
            // FileNotFoundException 编译异常，必须处理，使用 throws 继续声明抛出
            throw new FileNotFoundException("文件路径不是c:\\a.txt");
        }
        // 判断是否为 .txt 文件
        if (!fileName.endsWith(".txt")) {
            // 抛出 IO 异常
            throw new IOException("文件的后缀名不正确");
        }

        System.out.println("文件路径正确");
    }
}
