package demo10;

import java.io.*;
import java.util.HashMap;

/**
 * 缓冲流
 *
 * 缓冲流,也叫高效流，是对4个基本流的增强
 *
 * 字节缓冲流：BufferedInputStream，BufferedOutStream
 * 字符缓冲流：BufferedReader，BufferedWriter
 *
 * 缓冲流的基本原理，是在创建流对象时，创建一个内置的默认大小的缓冲区数组
 * 通过缓冲区读写，减少系统 IO 次数，从而提高读写的效率。
 *
 *
 */

public class BufferedMain {
    public static void main(String[] args) throws IOException {
//        copyFile();
        sortFile();

    }

    /**
     * 使用缓冲流复制文件
     * 1. 创建字节缓冲输入流对象，构造方法中传入字节输入流
     * 2. 创建字节缓冲输出流对象，构造方法中传入字节输出流
     * 3. 调用 read 方法读取文件
     * 4. 调用 write 方法把读取的数据写入到内部缓冲区
     * 5. 释放资源(会先把缓冲区的数据刷入文件中)
     */
    public static void copyFile() throws IOException {
        long s = System.currentTimeMillis();

        // 创建字节缓冲输入流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("module02\\src\\demo10\\java.png"));
        // 创建字节缓冲输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("module02\\src\\demo10\\java_copy.png"));

        // 一次读写一个字节
//        int len = 0;
//        while ((len = bis.read()) != -1) {
//            bos.write(len);
//        }

        // 创建缓冲数组，一次读写多个字节
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }


        // 释放资源
        bos.close();
        bis.close();

        long e = System.currentTimeMillis();
        System.out.println("复制文件共耗时：" + (e - s) + "毫秒");
    }


    /**
     * 使用缓冲流对文本内容进行排序
     * 1. 创建 HashMap 集合对象，key：每行文本的序号，value：每行文本数据
     * 2. 创建缓冲字符输入流对象，构造方法中传入字符输入流
     * 3. 创建缓冲字符输出流对象，构造方法中传入字符输出流
     * 4. 调用缓冲字符输入流的 readLine 方法，逐行读取文本
     * 5. 分割读取到的文本，获取序号和文本内容
     * 6. 把序号和文本内容存储到 HashMap 中
     * 7. 遍历 HashMap 集合，获取键值对，把键值对拼接成文本行
     * 8. 使用缓存输出流中的 write 方法，把键值对写入到文件中
     * 9. 释放资源
     */
    public static void sortFile() throws IOException {
        // 创建 HashMap 对象
        HashMap<String, String> map = new HashMap<>();
        // 创建缓冲字符输入流
        BufferedReader br = new BufferedReader(new FileReader("module02\\src\\demo10\\in.txt"));
        // 创建缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("module02\\src\\demo10\\out.txt"));

        // 逐行读取文本
        String line = null;
        while ((line = br.readLine()) != null) {
            // 分割每一行文本，获取序号和文本内容
            String[] arr = line.split("\\.");
            // 存储每行的序号和文本
            map.put(arr[0], arr[1]);
        }

        // 遍历集合，将数据写入文件
        for (String key : map.keySet()) {
            String value = map.get(key);
            line = key + "." + value;
            // 写入文本
            bw.write(line);
            // 写入换行
            bw.newLine();
        }

        // 释放资源
        bw.close();
        br.close();
    }

}
