package demo03;

/**
 * 测试继承
 */
public class ExtendsTest {

    public static void main(String[] args) {

        // 创建教师类对象
        Teacher teacher = new Teacher();
        // Teacher 类中虽然没有 method 方法，但是继承了父类 Employee 中的 method 方法
        teacher.method(); // Employee 类方法执行
        // 访问成员变量，优先使用子类的，没有就向上找
        System.out.println(teacher.title); // 教师


        // 创建一个助教类对象
        Assistant assistant = new Assistant();
        // Assistant 类中定义了 method 方法，则使用自己的方法
        assistant.method();
        // // 访问成员变量，优先使用子类的，没有就向上找
        System.out.println(assistant.title); // 助教

        // 旧手机类
        Phone phone = new Phone();
        phone.call();
        phone.send();
        phone.show();

        // 新手机类，继承了就手机类的功能，添加了新功能
        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();

        // 不能直接使用 new 创建抽象类的对象
        // Animal animal = new Animal(); // 报错
        // 子类实现抽象类的抽象方法
        Cat cat = new Cat();
        cat.eat(); // 猫吃鱼
    }

}
