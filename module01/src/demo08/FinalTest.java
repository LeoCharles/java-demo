package demo08;

/**
 * final 关键字
 * 含义：最终的，不可改变的
 *
 * 1.修饰一个类
 * 2.修饰一个方法
 * 3.修饰一个局部变量
 * 4.修饰一个成员变量
 */
public class FinalTest {

    public static void main(String[] args) {

        final int num = 10;
        // 使用 final 修饰局部变量，这个变量就不能被改变
        // num = 20; // 错误写法

        // 对于基本类型来说，不可变指的是数据内容
        // 对于引用类型来说，不可变值得是地址值

        Student stu1 = new Student("Leo");
        System.out.println(stu1);
        System.out.println(stu1.getName()); // Leo
        stu1 = new Student("Tom");
        System.out.println(stu1); // 地址值不一样
        System.out.println(stu1.getName()); // Tom

        final Student stu2 = new Student("Bob");
        // final 修饰的引用类型变量地址值不能改变
        // stu2 = new Student("Tom"); // 错误写法
        // 可以调用里面的方法
        stu2.setName("Tom");
        System.out.println(stu2.getName()); // Tom



    }
}

