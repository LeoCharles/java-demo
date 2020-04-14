package demo09;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * java.util.Properties extends HashTable
 * Properties 表示一个持久的属性集。它使用键值结构存储数据，每个键及其对应值都是一个字符串。
 * Properties 集合是唯一一个和 IO流相结合的集合。
 *
 * 基本的存储方法：
 * public Object setProperty(String key, String value)：保存一对属性。
 * public String getProperty(String key)：使用此属性列表中指定的键搜索属性值。
 * public Set<String> stringPropertyNames()：所有键的名称的集合。
 *
 * 与流相关的方法：
 * public void store(OutputStream out, String comments): 将此 Properties 表中的属性列表写入输出流。
 * public void store(Writer writer, String comments) : 将此 Properties 表中的属性列表写入输出字符。
 * public void load(InputStream inStream)：从字节输入流中读取键值对。
 * public void load(Reader reader)：从字节输入流中读取键值对。
 * 参数：
 * OutputStream out：字节输出流，不能输出中文
 * Writer writer：字符输出流
 * InputStream inStream: 字节输入流，不能读取含有中文的键值对
 * Reader reader：字符输入流
 * String comments：注释说明，不能使用中文，会有乱码
 *
 * store 方法使用步骤：
 * 1. 创建 Properties 集合对象，添加数据
 * 2. 创建字节/字符输出流，构造方法中传入要输出的目的地
 * 3. 调用 store 方法，把集合中的数据持久化写入磁盘文件中
 * 4. 释放资源
 *
 * load 方法使用步骤：
 * 1. 创建 Properties 集合对象
 * 2. 调用 load 方法，读取存有键值对的文件
 * 注意：
 * 1. 存储键值对的文件中，键与值的连接符可以使用 = 、空格
 * 2. 存储键值对的文件中，可以使用 # 进行注释
 * 3. 存储键值对的文件中，键和值默认是字符串，不需要再加引号
 *
 */

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
//        testCreate();
//        testStore();
        testLoad();

    }

    // 使用 Properties 存储数据并遍历
    public static void testCreate() {
        Properties prop = new Properties();

        // 使用 setProperty 添加键值对
        prop.setProperty("Leo", "20");
        prop.setProperty("Rex", "23");
        prop.setProperty("Eve", "30");

        // 使用 stringPropertyNames 取出所有的键名
        Set<String> names = prop.stringPropertyNames();
        for (String name : names) {
            // 使用 getProperty 通过键名获取键值
            String value = prop.getProperty(name);
            System.out.println("属性名：" + name + "， 属性值：" + value);
        }
    }

    // 使用 store 持久化保存数据
    public static void testStore() throws IOException {
        // 创建 Properties 对象
        Properties prop = new Properties();
        prop.setProperty("Leo", "20");
        prop.setProperty("Rex", "23");
        prop.setProperty("Eve", "30");

        // 创建字符流
        FileWriter fw = new FileWriter("module02\\src\\demo09\\prop.txt");

        // 使用 store 存储数据
        prop.store(fw, "save data");

        // 释放资源
        fw.close();
    }

    // 使用 load 从文件中读取键值对
    public static void testLoad() throws IOException {
        // 创建 Properties 对象
        Properties prop = new Properties();

        // 使用 load 方法读取数据
        prop.load(new FileReader("module02\\src\\demo09\\prop.txt"));

        // 遍历 Properties 集合
        Set<String> names = prop.stringPropertyNames();
        for (String name : names) {
            String value = prop.getProperty(name);
            System.out.println(name + " = " + value);
        }
    }
}
