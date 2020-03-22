package demo02;

import java.util.Random;

/**
 * 随机数生成器
 * 使用：
 * int random = new Random();
 *
 * int num = random.nextInt();
 */
public class RandomTest {
    public static void main(String[] args) {

        // 创建
        Random random = new Random();

        // 如果不传参数，则随机数范围是 int 所有范围，包括正负
//        int num1 = random.nextInt();
//        System.out.println("随机数是：" + num1);

        // 参数代表范围，左闭右开区间 [0, 10) 0~9
//        int num2 = random.nextInt(10);
//        System.out.println("随机数是：" + num2);

//        for (int i = 0; i < 100; i++) {
//            // 范围是 0 ~ 9
//            int num = random.nextInt(10);
//            System.out.println(i + "号随机数是：" + num);
//        }


        /**
         * 根据 int 变量 n 的值来获取随机数字 范围是 [1, n]
         * 思路：整体 +1
         */
        int n = 5;
        // 本来范围是[0, n) => [1, n+1) <=> [1, n]
        int res = random.nextInt(n) + 1;
        System.out.println("随机数是：" + res);

    }
}
