package demo11;

import java.io.*;

/**
 * 字符集 Charset
 *
 * ASCII字符集：
 * ASCII基本字符集，使用 7 位（bits）表示一个字符，共128字符，用于显示现代英语。
 * ASCII扩展字符集，使用 8 位（bits）表示一个字符，共256字符，支持欧洲常用字符。
 *
 * ISO-8859-1字符集：
 * 拉丁码表，别名Latin-1，用于显示欧洲使用的语言，使用单字节编码，兼容ASCII编码。
 *
 * GB字符集：
 * GB2312：简体中文码表。
 * GBK：常用的中文码表。使用了双字节编码方案，完全兼容 GB2312 标准，同时支持繁体汉字以及日韩汉字等。
 * GB18030：最新的中文码表。支持中国国内少数民族的文字，同时支持繁体汉字以及日韩汉字等。
 *
 * Unicode字符集:
 * Unicode编码系统为表达任意语言的任意字符而设计,最多使用4个字节的数字来表达每个字母、符号，或者文字。
 * 有三种编码方案，UTF-8、UTF-16 和 UTF-32。最为常用的 UTF-8 编码。
 * UTF-8：
 * 128个 ASCII 字符，使用一个字节编码。
 * 拉丁文等字符，使用二个字节编码。
 * 拉丁文等字符，需要二个字节编码。
 * 其他极少使用的Unicode辅助字符，使用四字节编码。
 *
 * 将 GBK 格式的文本文件，转换为 UTF-8 格式的文本文件
 * 1. 指定 GBK 编码的转换流，读取文本文件
 * 2. 使用 UTF-8 编码的转换流，写出文本文件
 *
 */

public class MainTest {
    public static void main(String[] args) throws IOException {
        gbkToUtf();
    }

    // 将 GBK 文件转换为 UTF-8 文件
    public static void gbkToUtf() throws IOException {
        // 创建 InputStreamReader 对象，构造方法中传入字节输入流和指定的编码表名称
        InputStreamReader isr = new InputStreamReader(new FileInputStream("module02\\src\\demo11\\gbk.txt"), "gbk");
        // 创建 OutputStreamWriter 对象，构造方法中传入字节输出流和指定的编码表名称
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("module02\\src\\demo11\\gbk2utf.txt"),"utf-8");

        // 读写文件
        int len = 0;
        while ((len = isr.read()) != -1) {
            osw.write(len);
        }


        // 释放资源
        osw.close();
        isr.close();
    }

}
