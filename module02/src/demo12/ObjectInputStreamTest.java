package demo12;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * java.io.ObjectInputStream extends InputStream 对象的反序列化流
 * ObjectInputStream 把文件中保存的对象，以流的方式读取出来
 *
 * 构造方法：
 * ObjectInputStream(InputStream in)：创建从指定 InputStream 读取的 ObjectInputStream。
 * 参数:
 * InputStream in：字节输入流
 *
 * 特有的方法：
 * Object readObject()：从 ObjectInputStream 读取对象。
 * 当不存在 对象的 class 文件时，会抛出 ClassNotFoundException 异常
 *
 * 反序列化的前提条件：
 * 1. 类必须实现 Serializable 接口
 * 2. 必须存在类对应的 class 文件
 *
 *
 * 使用步骤：
 * 1. 创建 ObjectInputStream 对象，构造方法中传入字节输入流
 * 2. 使用 readObject 方法，读取保存有对象的文件
 * 3. 释放资源
 *
 */

public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        readObject();
    }

    public static void readObject() throws IOException, ClassNotFoundException {
        // 创建 ObjectInputStream 对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("module02\\src\\demo12\\person.txt"));

        // 调用 readObject 方法，读取文件中的对象
        Object o = ois.readObject();

        Person p = (Person) o; // 可以强转成 Person 类型

        System.out.println(p);

        // 释放资源
        ois.close();
    }
}
