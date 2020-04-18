package demo12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * java.io.ObjectOutputStream extends OutputStream 对象的序列化流
 * ObjectOutputStream 将对象以流的方式写入到文件报错，实现对象的持久存储。
 *
 * 构造方法：
 * ObjectOutputStream(OutputStream out)：创建写入指定 OutputStream 的 ObjectOutputStream。
 * 参数：
 * OutputStream out：字节输出流
 *
 * 特有的成员方法：
 * void writeObject(Object obj)：将指定的对象写入
 *
 * 使用步骤：
 * 1. 创建 ObjectOutputStream 对象，构造方法中传入字节输出流对象
 * 2. 调用 writeObject 方法，把对象写入到文件中
 * 3. 释放资源
 *
 */

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        writeObject();
    }

    public static void writeObject() throws IOException {
        // 创建 ObjectOutputStream 对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("module02\\src\\demo12\\person.txt"));

        // 创建 Person 对象
        Person p1 = new Person("Leo", 30);

        // 调用 writeObject 方法把对象通过字节写入文件中
        oos.writeObject(p1);

        // 释放资源
        oos.close();
    }
}
