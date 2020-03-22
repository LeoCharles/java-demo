package demo02;

import java.util.Random;
import java.util.Scanner;

/**
 * 猜数字小游戏
 * 思路:
 * 1. 首先产生一个随机数字，产生后不再变化。
 * 2. 键盘输入猜的数字 Scanner。
 * 3. 比较输入数字和随机数大小
 * 4. 如果没猜对，继续键盘输入
 */
public class RandomGame {
    public static void main(String[] args) {

        Random random = new Random();

        // 获取一个 1 ~ 100 的随机数字
        int randomNum = random.nextInt(100) + 1;

        Scanner sc = new Scanner(System.in);

        // 计数器
        int count = 0;

        while (true) {
            System.out.println("请输入你猜测的数字：");
            // 键盘输入的数字
            int guessNum = sc.nextInt();
            count++;

            // 判断
            if (guessNum > randomNum) {
                System.out.println("你猜的数字太大了，请重试。");
            } else if (guessNum < randomNum) {
                System.out.println("你猜的数字太小了，请重试。");
            } else {
                System.out.println("恭喜你，猜对了！");
                // 如果猜对了，不再循环
                break;
            }
        }
        System.out.println("游戏结束，你一共猜了" + count + "次。");

    }
}
