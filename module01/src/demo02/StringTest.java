package demo02;

import java.util.Scanner;

public class StringTest {
    public static void main(String[] args) {

        // 方法1. 使用无参构造
        String s1 = new String();

        // 方法2. 根据字符数组创建字符串
        char[] charArray = {'h', 'e', 'l', 'l', 'o', '!'};
        String s2 = new String(charArray);
        System.out.println(s2); // hello!

        // 方法3. 根据字节数组创建字符串
        byte[] byteArray = {65, 66, 67};
        String s3 = new String(byteArray);
        System.out.println(s3); // ABC

        // 方法4. 使用字面量直接创建
        String s4 = "hello!"; // 这种方式也是字符串对象

        String str1 = "ABC";
        String str2 = "ABC";
        char[] chars = {'A', 'B', 'C'};
        String str3 = new String(chars);
        System.out.println(str1 == str2); // true
        System.out.println(str2 == str3); // false
        System.out.println(str3 == str1); // false

        // 使用 equals 方法比较，内容相同时返回 true
        System.out.println(str1.equals(str3)); // true
        System.out.println(str3.equals("ABC")); // true
        System.out.println("ABC".equals(str1)); // true

        // equalsIgnoreCase 忽略大小写比较内容
        System.out.println("ABC".equalsIgnoreCase("abc")); // true

        // concat 连接字符串，返回新的字符串
        System.out.println("Hello".concat(" World"));

        // charAt
        System.out.println("Hello".charAt(0)); // H

        // indexOf
        System.out.println("Hello".indexOf("el")); // 1

        // subString 截取字符串
        System.out.println("Hello".substring(2)); // llo
        System.out.println("Hello".substring(2, 4)); // ll

        // toCharArray
        char[] charArr = "Hello".toCharArray();
        System.out.println(charArr[0]); // H
        System.out.println(charArr.length); // 5


        // getBytes
        byte[] bytes1 = "Hello".getBytes();
        System.out.println(bytes1[0]);// 72
        System.out.println(bytes1[2]);// 108

        // replace
        System.out.println("Hello".replace("H", "h")); // hello

        // split
        String[] strArr = "aaa,bbb,ccc,ddd".split(",");
        System.out.println(strArr.length); // 4
        System.out.println(strArr[0]); // aaa
        System.out.println(strArr[1]); // bbb
        System.out.println(strArr[2]); // ccc
        // 参数是正则表达式，点号有特殊含义，需要转义
        String[] strArr2 = "XXX.YYY.ZZZ".split("\\.");
        System.out.println(strArr2[1]); // YYY



        /**
         * 题目1. 定义一个方法将 int 数组{1,2,3} 拼接成字符串[word1#word2#word3]
         *
         * 思路：字符串拼接  循环获取数组中的元素
         *
         */
        int[] arr1 = {1, 2, 3};
        System.out.println(arrToString(arr1));

        /**
         * 统计键盘输入中出现的字符种类次数，大写字母、小写字母、数字和其他
         *
         * 思路：
         * 获取键盘输入字符串 String str = sc.next()
         * 遍历字符串
         * 定义四个种类变量，统计各自出现的次数
         *
         */

        // 获取键盘输入的字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请随意输入字符串:");
        String scStr = sc.next();
        System.out.println("你输入的字符串是：" + scStr);
        // 将字符串转成字符数组
        char[] scCharArr = scStr.toCharArray();

        // 定义四个计数器
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;
        // 遍历数组 字符在比较的时候会自动转成 数字
        for (int i = 0; i < scCharArr.length; i++) {
            char ch = scCharArr[i];
            // char 类型在运算是会提升成 int 类型
            if ('0' <= ch && ch <= '9') {
                // 数字
                countNumber++;
            } else if ('A' <= ch  && ch <= 'Z') {
                // 大写字母
                countUpper++;
            } else if ('a' <= ch  && ch <= 'z') {
                // 小写字母
                countLower++;
            } else {
                countOther++;
            }
        }
        System.out.println("其中大写字母有：" + countUpper);
        System.out.println("其中小写字母有：" + countLower);
        System.out.println("其中数字有：" + countNumber);
        System.out.println("其他：" + countOther);

    }

    // 将 int 数组 转成字符串
    public static String arrToString(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                str += "world" + arr[i] + ']';
            } else {
                str += "world" + arr[i] + '#';
            }
        }
        return str;
    }
}
