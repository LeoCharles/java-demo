package demo10;

import java.io.*;

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
 * 使用缓存流复制文件：
 * 1. 创建字节缓冲输入流对象，构造方法中传入字节输入流
 * 2. 创建字节缓冲输出流对象，构造方法中传入字节输出流
 * 3. 调用 read 方法读取文件
 * 4. 调用 write 方法把读取的数据写入到内部缓冲区
 * 5. 释放资源(会先把缓冲区的数据刷入文件中)
 *
 *
 *
 *
 */

public class BufferedMain {
    public static void main(String[] args) throws IOException {
        copyFile();
    }

    // 使用缓冲流复制文件
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

}
