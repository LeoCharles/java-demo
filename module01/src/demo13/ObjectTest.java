package demo13;

/**
 * Object 类
 *
 * java.lang.Object 是所有类的父类
 *
 * 如果一个类没有特别指定父类，那默认继承 Object
 *
 * Object 类的 toString 方法返回由 类名 + @ +内存地址的字符串
 *
 * Object 类中 equals 方法默认进行 == 运算符的对象地址比较
 * 只要不是同一个对象，结果必然为 false 。
 * 如果希望进行对象的内容比较，可以覆盖重写 equals 方法。
 */
public class ObjectTest /*extends Object*/ {

    public static void main(String[] args) {

        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        // 使用重写的 toString 方法
        System.out.println(p1.toString());

        // 使用重写的 equals方法
        System.out.println(p1.equals(p2));


    }
}
