package demo12;

import java.io.*;
import java.util.ArrayList;

/**
 * 把对象以流的方式写入到文件中持久化保存，称为对象的序列化
 * 把文件中保存的对象，以流的方式读取出来，称为对象的反序列化
 *
 * static：静态关键字
 * 静态优先于对象加载到内存中，被 static 修饰的成员变量不能被序列化
 *
 * transient：瞬态关键字
 * 被 transient 修饰的成员变量，不能被序列化
 *
 *
 * 反序列化的前提条件：
 * 1. 类必须实现 Serializable 接口
 * 2. 必须存在类对应的 class 文件
 *
 *
 * 注意：
 * 反序列化读取对象时，如果对象的 class 文件不存在，会抛出 ClassNotFoundException 异常
 * 如果存在 class 文件，但是 class 文件在序列化对象后发生了修改，则会抛出 InvalidClassException 异常
 *
 *
 * 可序列化类可以通过显式声明自己的 serialVersionUID，指定一个序列化版本号
 * 无论是否对类进行修改，都不会生成新的序列化版本号
 *
 */

public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialList();
    }

    /**
     * 序列化集合
     * 把多个对象保存到集合中，对集合进行序列化和反序列化操作
     * 1. 定义一个存储 Person 对象的 ArrayList集合
     * 2. 创建 ObjectOutputStream 序列化流，调用 writeObject 方法，对集合序列化
     * 3. 创建 ObjectInputStream 反序列化流，调用 readObject 方法，读取文件中保存的集合
     * 4. 把读出的 Object 类型集合转换为 ArrayList 类型，遍历 ArrayList 集合
     * 5. 释放资源
     *
     */
    public static void serialList() throws IOException, ClassNotFoundException {
        // 创建 ArrayList 集合
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Leo", 30));
        list.add(new Person("Rex", 20));
        list.add(new Person("Eve", 33));
        list.add(new Person("Ali", 21));

        // 创建序列化流 ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("module02\\src\\demo12\\list.txt"));
        // 将集合写入文件
        oos.writeObject(list);

        // 创建反序列化流 ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("module02\\src\\demo12\\list.txt"));
        // 从文件中读取集合
        Object o = ois.readObject();
        // 转换成集合
        ArrayList<Person> personList = (ArrayList<Person>) o;
        for (Person p : personList) {
            System.out.println(p);
        }

        // 释放资源
        ois.close();
        oos.close();
    }
}
