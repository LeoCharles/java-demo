package demo02;

import java.util.Scanner; // 导包

/**
 * Scanner 类可以实现从键盘输入数据到程序中
 *
 * 引用类型的一般使用步骤
 * 1. 导包
 * import 包路径.类名称
 * 只有 Java.lang 下的内容不需要导包，其他的都需要 import
 * 2. 创建
 * 类名称 对象名 = new 类名称()
 * 3. 使用
 * 对象名.成员方法名()
 * 获取键盘输入的一个 int 数字 int num =  sc.nextInt()
 * 获取键盘输入的字符串   String str =  sc.next()
 */


public class ScannerTest {

    public static void main(String[] args) {

        // System.in 表示从键盘输入
        Scanner sc = new Scanner(System.in);


        // 键盘输入两个数字，并求和
        System.out.print("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.print("请输入第二个数字：");
        int num2 = sc.nextInt();
        int sum = num1 + num2;
        System.out.println("他们的和是：" + sum);

        // 获取键盘输入的字符串
        String str = sc.next();
        System.out.println("输入的字符串是：" + str);


    }


}
