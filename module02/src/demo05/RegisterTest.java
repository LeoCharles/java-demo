package demo05;

import java.util.Scanner;

/**
 * 模拟注册，如果用户名已存在，则抛出异常
 *
 * 1. 使用数组保存已经注册过的用户名
 * 2. 使用 Scanner 获取用户名输入的用户名
 *
 *
 */
public class RegisterTest {
    static String[] users = {"Leo", "Tom", "Rex", "Van"};

    public static void main(String[] args) /*throws RegisterException*/ {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要注册的用户名：");
        String name = sc.next();
        checkName(name);


    }

    public static void checkName(String name) /*throws RegisterException*/ {
        for (String user : users) {
            if (name.equals(user)) {
                // 有相同的用户名，就抛出异常
                try {
                    throw new RegisterException("该用户名已注册");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return; // 结束方法
                }
            }
        }
        System.out.println("恭喜您，注册成功！");
    }

}
