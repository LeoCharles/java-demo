package demo01;

/**
 * 定义一个类用来模拟学生
 */
public class Student {

    // 成员变量
    String name;
    String sex;
    int age;

    // 成员方法(没有 static)
    public void study() {
        System.out.println("认真学习");
    }

    public void getInfo() {
        System.out.println("学生信息：");
        System.out.println("姓名：" + this.name);
        System.out.println("性别：" + this.sex);
        System.out.println("年龄：" + this.age);
    }
}
