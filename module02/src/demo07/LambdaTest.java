package demo07;

import java.util.Arrays;

/**
 * Lambda 表达式
 *
 * 匿名内部类可以省去实现类的定义，但是语法太复杂。
 *
 * 使用 Lambda 表达式，可以不必编写单方法接口(FunctionalInterface)的实现类，从而简化代码。
 *
 * Lambda 标准格式
 *
 * (参数类型 参数名称) ‐> { 重写接口的抽象方法的方法体 }
 *
 * 格式说明：
 * (): 接口中抽象方法的参数列表，无参数则留空，多个参数则用逗号分隔
 * ->：新引入的语法格式，代表指向动作，把参数传递给方法体
 * {}：重写接口的抽象方法的方法体
 *
 * Lambda 表达式可推导，可省略
 * 1. (参数列表)：参数列表的数据类型可以省略
 * 2. (参数列表)：参数如果只有一个，那么类型和 () 都可以省略
 * 3. {方法体}： 如果方法体只有一行，无论是否有返回值，都可以省略 {}、return、';'
 *
 * 使用 Lambda 语法的前提：
 * 1. 方法中必须有接口，且接口中仅有一个抽象方法，即函数式接口
 * 2. 方法的参数或局部变量类型必须为 Lambda 对应的接口类型
 *
 *
 *
 */
public class LambdaTest {
    public static void main(String[] args) {
//        testThread();
        testSort();
        // 使用匿名内部类
        testCalc(10, 20, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        // 使用 Lambda 表达式
        testCalc(10, 20, (int a, int b) -> {
            return a + b;
        });

        // 省略优化 Lambda
        testCalc(10, 20, (a, b) -> a + b);
    }

    public static void testThread() {
        // 使用匿名内部类实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建新线程");
            }
        }).start();

        // 使用 Lambda 表达式实现多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "创建新线程");
        }).start();

        // 省略优化 Lambda
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "创建新线程")).start();
    }


    public static void testSort() {
        Person[] arr = {
                new Person("Rex", 23),
                new Person("Leo", 30),
                new Person("Eve", 32),
                new Person("Bob", 33)
        };
        // 匿名内部类
//        Arrays.sort(arr, new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.getAge() - p2.getAge();
//            }
//        });

        // 使用 Lambda 简化匿名内部类
//        Arrays.sort(arr, (Person p1,Person p2) -> {
//            return p1.getAge() - p2.getAge();
//        });

        // 省略优化 Lambda
        Arrays.sort(arr, (p1, p2) -> p1.getAge() - p2.getAge());


        for (Person p : arr) {
            System.out.println(p);
        }
    }

    // 传递两个 int 整数和 Calculator 接口，
    // 方法内部调用 Calculator 接口中的 calc 方法，计算两个整数的和
    public static void testCalc(int a, int b, Calculator c) {
        int sum = c.calc(a, b);
        System.out.println(sum);
    }

}
